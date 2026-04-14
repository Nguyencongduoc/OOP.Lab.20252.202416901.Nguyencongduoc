package hust.soict.elitech.hedspi.Lab02.AimsProject.src;

public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 21.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 15.95f);

        anOrder.addDVD(dvd1);
        anOrder.addDVD(dvd2, dvd3);
        DigitalVideoDisc[] dvdList = {dvd4, dvd5};
        anOrder.addDVD(dvdList);

        anOrder.displayCart();

        //test chuc nang xoa
        anOrder.removeDVD(dvd1);
        anOrder.displayCart();
    }
}
