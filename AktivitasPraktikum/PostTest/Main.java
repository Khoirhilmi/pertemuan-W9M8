package PostTest;
import java.util.Calendar;
import java.util.Date;

// Komposisi: License
class License {
    private String licenseNumber;
    private Date validUntil;

    public License(String licenseNumber, int validYears) {
        this.licenseNumber = licenseNumber;

        // Hitung tanggal berlaku lisensi
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, validYears);
        this.validUntil = calendar.getTime();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Date getValidUntil() {
        return validUntil;
    }
}

// Superclass: Vehicle
abstract class Vehicle {
    public abstract void startEngine();
}

// Subclass: Car
class Car extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Mesin Mobil Nyala");
    }
}

// Subclass: Motorcycle
class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Mesin Motor Nyala");
    }
}

// Driver → Agregasi ke Vehicle, Komposisi ke License
class Driver {
    private String name;
    private Vehicle vehicle;
    private License license;

    public Driver(String name, Vehicle vehicle, String licenseNumber, int validYears) {
        this.name = name;
        this.vehicle = vehicle;
        this.license = new License(licenseNumber, validYears);
    }

    public void showInfo() {
        System.out.println("Nama Pengemudi: " + name);

        // Gunakan instanceof untuk menentukan jenis kendaraan
        System.out.print("Jenis Kendaraan: ");
        if (vehicle instanceof Car) {
            System.out.println("Mobil");
        } else if (vehicle instanceof Motorcycle) {
            System.out.println("Motor");
        } else {
            System.out.println("Tidak diketahui");
        }

        // Status mesin
        System.out.print("Status Mesin: ");
        vehicle.startEngine();

        // Informasi lisensi
        System.out.println("Nomor Lisensi: " + license.getLicenseNumber());
        System.out.println("Berlaku Hingga: " + license.getValidUntil());
        System.out.println();
    }
}

// Main Program
public class Main {
    public static void main(String[] args) {
        // Buat objek Driver
        Driver driver1 = new Driver("Andi", new Car(), "CAR123456", 5);
        Driver driver2 = new Driver("Rina", new Motorcycle(), "MOTO654321", 3);

        // Tampilkan informasi
        driver1.showInfo();
        driver2.showInfo();
    }
}
