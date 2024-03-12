package ra.bussiness;


import test.Product;

import java.util.Scanner;

public class BookManagement {
    private static Book[] products = new Book[100];
    static  {
        products[0] = new Book("P001", "Sách 1", 100, 150, 50, 10, "Mô tả sản phẩm 1", true);
        products[1] = new Book("P002", "Sách 2", 120, 180, 60, 15, "Mô tả sản phẩm 2", true);
        products[2] = new Book("P003", "Sách 3", 150, 200, 50, 20, "Mô tả sản phẩm 3", false);
    }
    private static int length = 3;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(
                    "****************JAVAVAVA-HACKATATHON-05-BASIC-MENU*************** \n"+
                    "1. Nhập thông tin cho n sản phẩm (n nhập từ bàn phím) \n" +

                            "2. Hiển thị thông tin các sách \n" +

                            "3. Sắp xếp các sản phẩm theo lợi nhuận giảm dần \n" +

                            "4. Xóa sách theo mã sách \n" +

                            "5. Tìm các sản phẩm theo tên sách \n"+

                            "6. Thay đổi thông tin sách theo mã sách \n"+

                            "7. Thoát ");
            System.out.println("Moi lua chon");
            int choice =  Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    creatProduct();
                    break;
                case 2:
                    showAllProduct();
                    break;
                case 3:
                    selectionSortProfit();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    searchProductName();
                    break;
                case 6:
                    updateStatusProduct();
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }while (true);

    }
    public static void creatProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Muốn nhập thêm mấy sản phẩm :");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            boolean checkID = false;
            do {
                System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): ");
                String inputProductId = scanner.nextLine();
                if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') {
                    boolean checkNewID = false;
                    for (int j = 0; j < length; j++) {
                        if (products[j].getBookID().equals(inputProductId)) {
                            checkNewID = true;
                            break;
                        }
                    }
                    if (!checkNewID) {
                        checkID = true;
                        products[length] = new Book();
                        products[length].inputData(scanner);
                        products[length].setBookID(inputProductId);
                        length++;
                    }else {
                        System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại.");
                    }
                } else {
                    System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại.");
                }
            } while (!checkID);
        }
    }

    public static void showAllProduct(){
        for (int i = 0; i < length; i++) {
            products[i].displayData();
        }
    }

    public static void calculateProfit(){
        System.out.println("Lợi nhuận của các sản phẩm:");
        for (int i = 0; i < length; i++) {
            products[i].calProfit();
            System.out.println("Sản phẩm " + products[i].getBookID() + ": " + products[i].getProfit());
        }
    }

    public static void selectionSortProfit(){
        for (int i = 0; i < length; i++) {
            int maxIndex = i;
            for (int j = i+1; j < length; j++) {
                if (products[j].getProfit()>products[i].getProfit()){
                    maxIndex=j;
                }
            }
            Book temp = products[i];
            products[i]=products[maxIndex];
            products[maxIndex] = temp;
        }
        System.out.println("Đã sắp xếp sản phẩm theo profit tăng dần.");
    }

    public static void exportPriceRange(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá thấp nhất trong khoảng giá bán");
        float fromExportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá cao nhất trong khoảng giá bán");
        float toExportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Sản phẩm trong khoảng giá bán từ "+fromExportPrice+" đến "+toExportPrice+" là:");
        boolean checkExportPrice = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getExportPrice() >= fromExportPrice && products[i].getImportPrice() <= toExportPrice){
                products[i].displayData();
                checkExportPrice = true;
            }
        }
        if (!checkExportPrice){
            System.out.println("Không có sản phẩm trong khoảng giá bán từ "+fromExportPrice+" đến "+toExportPrice);
        }
    }

    public static void searchProductName (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sản phầm cần tìm:");
        String inputName = scanner.nextLine();
        boolean checkName = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getBookID().equals(inputName)){
                products[i].displayData();
                checkName= true;
            }
        }if (!checkName){
            System.out.println("Không co sản phẩm với tên cần tìm");
        }
    }

    public static void inputProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phầm :");
        String inputProductID = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getBookID().equals(inputProductID)){
                check = true;
                System.out.println("Nhập số lượng cần them:");
                int addQuantity = Integer.parseInt(scanner.nextLine());
                products[i].setQuantity(products[i].getQuantity() + addQuantity);
                System.out.println("Số lượng sản phẩm đã được cập nhật thành công.");
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sản phẩm với mã sản phẩm đã nhập.");
        }
    }

    public static void sellProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phầm :");
        String inputProductName = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getBookName().equals(inputProductName)) {
                check = true;
                if (products[i].getBookStatus()) {
                    System.out.println("Nhập số lượng sản phẩm cần bán:");
                    int soldQuantity = Integer.parseInt(scanner.nextLine());
                    if (soldQuantity <= products[i].getQuantity()) {
                        products[i].setQuantity(products[i].getQuantity() - soldQuantity);
                        System.out.println("Sản phẩm dã bán thành công");
                    } else {
                        System.out.println("Số lượng sp bán vuot qua số lượng sp hiện có");
                    }
                } else {
                    System.out.println("Sản phẩm không còn bán");
                }
            }
        }
        if (!check){
            System.out.println("Không có tên sản phẩm ");
        }
    }

    public static void updateStatusProduct(){
        boolean checkID = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): ");
            String inputProductId = scanner.nextLine();
            if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') {
                checkID = true;
                boolean check = false;
                for (int i = 0; i < length; i++) {
                    if (products[i].getBookID().equals(inputProductId)){
                        check =true;
                        if (products[i].getBookStatus()) {
                            products[i].setBookStatus(false);
                            System.out.println("Đã cập nhật trạng thái mã ("+inputProductId+ ") chuyển sang : Chưa bán");
                        } else {
                            products[i].setBookStatus(true);
                            System.out.println("Đã cập nhật trạng thái mã ("+inputProductId+ ") chuyển sang : Đang bán");
                        }
                        break;
                    }
                }
                if (!check){
                    System.out.println("Mã sản phẩm không có ");
                }
            } else {
                System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại.");
            }
        }while (!checkID);
    }

    public static void deleteProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm cần xóa:");
        String delProductId = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < length; i++) {
            if (products[i].getBookID().equals(delProductId)) {
                check = true;
                for (int j = i; j < length - 1; j++) {
                    products[j] = products[j + 1];
                }
                length--;
                System.out.println("Đã xóa sản phẩm có mã: " + delProductId);
                break;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + delProductId);
        }
    }


}


