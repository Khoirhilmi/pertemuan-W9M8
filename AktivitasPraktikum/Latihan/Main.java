package Aktivitas.Latihan;
import java.util.Date;

//komposisi
class HealthRecord {
    private String recordNumber;
    private Date creationDate;

    public HealthRecord(String recordNumber, Date creationDate) {
        this.recordNumber = recordNumber;
        this.creationDate = creationDate;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}

//superclass
abstract class Animal {
    protected HealthRecord healthRecord;

    public Animal(String recordNumber) {
        this.healthRecord = new HealthRecord(recordNumber, new Date());
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }

    public abstract void makeSound();
}

//subclass = dog
class Dog extends Animal {
    public Dog(String recordNumber) {
        super(recordNumber);
    }

    @Override
    public void makeSound() {
        System.out.println("Guk-Guk!");
    }
}

//subclass = cat
class Cat extends Animal {
    public Cat(String recordNumber) {
        super(recordNumber);
    }

    @Override
    public void makeSound() {
        System.out.println("Meong!");
    }
}

//HAS-A agregasi
class Owner {
    private String name;
    private Animal pet;

    public Owner(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void showInfo() {
        System.out.println("Nama Pemilik: " + name);
        System.out.print("Suara Hewan Peliharaan: ");
        pet.makeSound();

        System.out.print("Jenis Hewan: ");
        if (pet instanceof Dog) {
            System.out.println("Dog");
        } else if (pet instanceof Cat) {
            System.out.println("Cat");
        } else {
            System.out.println("Tidak diketahui");
        }

        System.out.println("Nomor Rekam Medis: " + pet.getHealthRecord().getRecordNumber());
        System.out.println("Tanggal Rekam Medis: " + pet.getHealthRecord().getCreationDate());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Budi", new Dog("DOG12345"));
        Owner owner2 = new Owner("Siti", new Cat("CAT67890"));

        owner1.showInfo();
        owner2.showInfo();
    }
}
