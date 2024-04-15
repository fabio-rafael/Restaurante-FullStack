import { useEffect, useState } from "react";
import { useMenuDataAlter } from "../../hooks/useMenuAlter";
import { MenuData } from "../../interface/MenuData";
import "./modal.css";

interface InputProps {
  label: string;
  value: string | number;
  updateValue(value: any): void;
}

const Input = ({ label, value, updateValue }: InputProps) => {
  return (
    <>
      <label>{label}</label>
      <input
        value={value}
        onChange={(e) => updateValue(e.target.value)}
      ></input>
    </>
  );
};

interface ModalProps {
  closeModal(): void;
}
export function CreateModal({ closeModal }: ModalProps) {
  const [title, setTitle] = useState("");
  const [price, setPrice] = useState(0);
  const [image, setImage] = useState("");
  const { mutate, isSuccess, isLoading } = useMenuDataAlter();

  const submit = () => {
    const menuData: MenuData = {
      title,
      price,
      image,
    };
    mutate(menuData);
  };

  useEffect(() => {
    if (!isSuccess) return;
    closeModal();
  }, [isSuccess]);

  return (
    <div className="modal-overlay">
      <div className="modal-body">
        <h2>Registre um novo prato no menu</h2>
        <form className="input-container">
          <Input label="title" value={title} updateValue={setTitle} />
          <Input label="price" value={price} updateValue={setPrice} />
          <Input label="image" value={image} updateValue={setImage} />
        </form>
        <button className="btn-secondary" onClick={submit}>
          {isLoading ? "loading..." : "Registrar"}
        </button>
      </div>
    </div>
  );
}
