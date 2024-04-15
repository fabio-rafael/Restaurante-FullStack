import { useState } from "react";
import "./App.css";
import { Card } from "./components/card/card";
import { useMenuData } from "./hooks/useMenuData";
import { CreateModal } from "./components/create-modal/create-modal";

function App() {
  const { data } = useMenuData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen((prev) => !prev);
  };

  return (
    <>
      <div className="container">
        <h1>Menu</h1>
        <div className="card-grid">
          {data?.map((menuData) => (
            <Card
              price={menuData.price}
              title={menuData.title}
              image={menuData.image}
            />
          ))}
        </div>
        {isModalOpen && <CreateModal closeModal={handleOpenModal} />}
        <button onClick={handleOpenModal}>Novo Item</button>
      </div>
    </>
  );
}

export default App;
