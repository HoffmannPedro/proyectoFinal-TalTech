package com.alphapets;

import com.alphapets.models.*;
import com.alphapets.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productoRepository.count() == 0) {

            // Alimento de Perro
            Alimento alimentoPerro = new Alimento();
            alimentoPerro.setNombre("Royal Canin Mini Adulto");
            alimentoPerro.setDescripcion("Alimento balanceado para perros de raza pequeña, 3kg.");
            alimentoPerro.setPrecio(28500);
            alimentoPerro.setStock(20);
            alimentoPerro.setImagenUrl("https://tiendademascotasar.vtexassets.com/arquivos/ids/156922-1200-auto?v=637735500926730000&width=1200&height=auto&aspect=true");
            alimentoPerro.setPesoKg(3.0);
            alimentoPerro.setEsHipoalergenico(false);

            // Accesorio 
            Accesorio juguete = new Accesorio();
            juguete.setNombre("Hueso de Goma Resistente");
            juguete.setDescripcion("Juguete masticable para limpiar dientes, sabor menta.");
            juguete.setPrecio(5500);
            juguete.setStock(50);
            juguete.setImagenUrl("https://m.media-amazon.com/images/I/71peK3oyreL.jpg");
            juguete.setTalla("M");
            juguete.setMaterial("Goma Natural");

            // Alimento de Gato
            Alimento alimentoGato = new Alimento();
            alimentoGato.setNombre("Whiskas Gatitos");
            alimentoGato.setDescripcion("Sabor Pescado y Leche, bolsa de 1kg.");
            alimentoGato.setPrecio(8200);
            alimentoGato.setStock(30);
            alimentoGato.setImagenUrl("https://walmartgt.vtexassets.com/arquivos/ids/514509/Alimento-Seco-para-Gatito-Whiskas-Pollo-1-4kg-1-37980.jpg?v=638478526145030000");
            alimentoGato.setPesoKg(1.0);
            alimentoGato.setEsHipoalergenico(false);

            // Guardamos todo
            productoRepository.save(alimentoPerro);
            productoRepository.save(juguete);
            productoRepository.save(alimentoGato);
        }
    }
}