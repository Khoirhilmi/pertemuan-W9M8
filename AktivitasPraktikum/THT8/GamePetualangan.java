package THT8;
import java.util.*;

public class GamePetualangan {
    static Scanner input = new Scanner(System.in);
    static Map<String, String> akun = new HashMap<>();
    static List<String> inventory = new ArrayList<>();
    static Random random = new Random();
    static int posisi = 0;
    static boolean bermain = true;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Keluar");
            System.out.print("Pilih menu: ");
            String menu = input.nextLine();
            switch (menu) {
                case "1":
                    register();
                    break;
                case "2":
                    if (login()) {
                        mulaiGame();
                    }
                    break;
                case "3":
                    System.out.println("Keluar dari game.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void register() {
        System.out.print("Buat username: ");
        String user = input.nextLine();
        if (akun.containsKey(user)) {
            System.out.println("Username sudah terdaftar.");
            return;
        }
        System.out.print("Buat password: ");
        String pass = input.nextLine();
        akun.put(user, pass);
        System.out.println("Registrasi berhasil!");
    }

    static boolean login() {
        System.out.print("Username: ");
        String user = input.nextLine();
        System.out.print("Password: ");
        String pass = input.nextLine();

        if (akun.containsKey(user) && akun.get(user).equals(pass)) {
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("Login gagal.");
            return false;
        }
    }

    static void mulaiGame() {
        posisi = 0;
        inventory.clear();
        bermain = true;
        System.out.println("Selamat datang di dunia petualangan!");

        while (bermain) {
            System.out.print("\nAksi (maju/mundur/status/keluar): ");
            String aksi = input.nextLine().toLowerCase();
            switch (aksi) {
                case "maju":
                    posisi++;
                    eventAcak();
                    break;
                case "mundur":
                    posisi--;
                    eventAcak();
                    break;
                case "status":
                    tampilkanStatus();
                    break;
                case "keluar":
                    bermain = false;
                    System.out.println("Keluar dari petualangan.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenali.");
            }
        }
    }

    static void eventAcak() {
        int event = random.nextInt(4);
        switch (event) {
            case 0:
                String item = getItemAcak();
                inventory.add(item);
                System.out.println("Kamu menemukan item: " + item);
                break;
            case 1:
                System.out.println("Kamu bertemu monster! Kamu berhasil kabur.");
                break;
            case 2:
                System.out.println("Kamu menemukan harta karun! Tambahkan ke inventory.");
                inventory.add("Harta Karun");
                break;
            case 3:
                System.out.println("Langkahmu sepi, tidak terjadi apa-apa.");
                break;
        }
    }

    static String getItemAcak() {
        String[] items = {"Pedang", "Perisai", "Ramuan", "Peta", "Koin Emas"};
        return items[random.nextInt(items.length)];
    }

    static void tampilkanStatus() {
        System.out.println("Posisi saat ini: " + posisi);
        System.out.println("Inventory: " + inventory);
    }
}
