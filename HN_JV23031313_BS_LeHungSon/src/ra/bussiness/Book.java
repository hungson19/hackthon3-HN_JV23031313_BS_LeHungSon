//package ra.bussiness;
//
//import java.util.Scanner;
//
//public class Book {
//    private String bookID;
//    private String bookName;
//    private String author;
//    private float importPrice;
//    private float exportPrice;
//    private float profit;
//
//    private int quantity;
//    private  String descriptions;
//    private Boolean bookStatus;
//    public Book(){
//    }
//
//    public Book(String bookID, String bookName, String author, float importPrice, float exportPrice, float profit, int quantity, String descriptions, Boolean bookStatus) {
//        this.bookID = bookID;
//        this.bookName = bookName;
//        this.author = author;
//        this.importPrice = importPrice;
//        this.exportPrice = exportPrice;
//        this.profit = profit;
//        this.quantity = quantity;
//        this.descriptions = descriptions;
//        this.bookStatus = bookStatus;
//    }
//
//    public String getBookID() {
//        return bookID;
//    }
//
//    public void setBookID(String bookID) {
//        this.bookID = bookID;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public float getImportPrice() {
//        return importPrice;
//    }
//
//    public void setImportPrice(float importPrice) {
//        this.importPrice = importPrice;
//    }
//
//    public float getExportPrice() {
//        return exportPrice;
//    }
//
//    public void setExportPrice(float exportPrice) {
//        this.exportPrice = exportPrice;
//    }
//
//    public float getProfit() {
//        return profit;
//    }
//
//    public void setProfit(float profit) {
//        this.profit = profit;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getDescriptions() {
//        return descriptions;
//    }
//
//    public void setDescriptions(String descriptions) {
//        this.descriptions = descriptions;
//    }
//
//    public Boolean getBookStatus() {
//        return bookStatus;
//    }
//
//    public void setBookStatus(Boolean bookStatus) {
//        this.bookStatus = bookStatus;
//    }
//
//    public void inputData(Scanner scanner){
////        boolean checkID = false;
////        do {
////            System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): ");
////            String inputProductId = scanner.nextLine();
////            if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') {
////                checkID = true;
////                productID = inputProductId;
////            } else {
////                System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại.");
////            }
////        }while (!checkID);
////        Nhập ten sản phẩm :
//        boolean checkName = false;
//        do {
//            System.out.println("Nhập tên sản phẩm (độ dài 5-50 ký tự): ");
//            String inputProductName = scanner.nextLine();
//            if (inputProductName.length() >= 5 && inputProductName.length() <= 50) {
//                checkName = true;
//                bookName = inputProductName;
//            } else {
//                System.out.println("Tên sản phẩm không hợp lệ. Vui lòng nhập lại.");
//            }
//        }while (!checkName);
//
//        System.out.println("Nhập giá nhâp sản phẩm :");
//        importPrice = Float.parseFloat(scanner.nextLine());
//        System.out.println("Nhập giá xuất sản phẩm :");
//        exportPrice = Float.parseFloat(scanner.nextLine());
//        System.out.println("Nhâp số lượng sản phẩm :");
//        quantity = Integer.parseInt(scanner.nextLine());
//        System.out.println("Mô tả sản phẩm");
//        descriptions = scanner.nextLine();
//        System.out.println("Trang thái sản phẩm :");
//        bookStatus = Boolean.parseBoolean(scanner.nextLine());
//    }
//
//    public void displayData(){
//        System.out.println("Product{" +
//                "productID='" + bookID + '\'' +
//                ", productName='" + bookName + '\'' +
//                ", importPrice=" + importPrice +
//                ", exportPrice=" + exportPrice +
//                ", profit=" + profit +
//                ", quantity=" + quantity +
//                ", descriptions='" + descriptions + '\'' +
//                ", status=" + (bookStatus?"Đang bán":"Không bán") +
//                '}');
//        System.out.println("=========================================");
//    }
//    public void calProfit() {
//        profit = exportPrice - importPrice;
//    }
//}


package ra.bussiness;

import java.util.Scanner;

public class Book {
    private String bookID;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private float profit;

    private int quantity;
    private  String descriptions;
    private Boolean bookStatus;

    public Book() {
    }

    public Book(String bookID, String bookName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, Boolean bookStatus) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.bookStatus = bookStatus;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner){
//        boolean checkID = false;
//        do {
//            System.out.println("Nhập mã sản phẩm (độ dài 4 ký tự, bắt đầu bằng 'P'): ");
//            String inputProductId = scanner.nextLine();
//            if (inputProductId.length() == 4 && inputProductId.charAt(0) == 'P') {
//                checkID = true;
//                productID = inputProductId;
//            } else {
//                System.out.println("Mã sản phẩm không hợp lệ. Vui lòng nhập lại.");
//            }
//        }while (!checkID);
//        Nhập ten sản phẩm :
        boolean checkName = false;
        do {
            System.out.println("Nhập tên sản phẩm (độ dài 5-50 ký tự): ");
            String inputProductName = scanner.nextLine();
            if (inputProductName.length() >= 5 && inputProductName.length() <= 50) {
                checkName = true;
                bookName = inputProductName;
            } else {
                System.out.println("Tên sản phẩm không hợp lệ. Vui lòng nhập lại.");
            }
        }while (!checkName);

        System.out.println("Nhập giá nhâp sản phẩm :");
        importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá xuất sản phẩm :");
        exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhâp số lượng sản phẩm :");
        quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Mô tả sản phẩm");
        descriptions = scanner.nextLine();
        System.out.println("Trangj thái sản phẩm :");
        bookStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData(){
        System.out.println("Product{" +
                "productID='" + bookID + '\'' +
                ", productName='" + bookName + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", profit=" + profit +
                ", quantity=" + quantity +
                ", descriptions='" + descriptions + '\'' +
                ", status=" + (bookStatus?"Đang bán":"Không bán") +
                '}');
        System.out.println("=========================================");
    }
    public void calProfit() {
        profit = exportPrice - importPrice;
    }
}
