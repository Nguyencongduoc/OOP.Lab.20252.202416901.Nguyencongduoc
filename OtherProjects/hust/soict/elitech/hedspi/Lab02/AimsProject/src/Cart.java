package hust.soict.elitech.hedspi.Lab02.AimsProject.src;

public class Cart {
    private int qtyOrdered = 0;
    private final int maxItem = 20;
    private DigitalVideoDisc[] items = new DigitalVideoDisc[maxItem];

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered < maxItem) {
            items[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("The disc '" + dvd.getTitle() + "' has been added.");
        }
        else {
            System.out.println("The cart is almost full. Cannot add '" + dvd.getTitle() + "'.");
        }
    }
    //Override Method
    public void addDVD(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDVD(dvd);
        }
    }

    public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDVD(dvd1);
        addDVD(dvd2);
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i] == dvd) {
               // Dich het sang trai
                for (int j = i; j < qtyOrdered - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[qtyOrdered - 1] = null; // Xóa phần tử cuối
                qtyOrdered--;
                found = true;
                System.out.println("The disc '" + dvd.getTitle() + "' has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart.");
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += items[i].getCost(); // lay chi phi
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + items[i].getTitle() + " - $" + items[i].getCost());
        }
        System.out.println("Total cost: [" + calculateTotalCost() + "] $");
    }
}