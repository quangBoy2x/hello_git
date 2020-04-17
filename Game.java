package SODOKU;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private Scanner sc = new Scanner(System.in);
    private int r, c, v;

    public void tick(){
        System.out.println("nhap hang muon danh:");
        r = sc.nextInt() - 1;
        System.out.println("nhap cot muon danh:");
        c = sc.nextInt() - 1;
        System.out.println("nhap so muon danh:");
        v = sc.nextInt();
        int n =r*8+c;
        Node e = new Node(r, c, v);
        if(!this.nodes.get(n).isValidate()) {
            System.out.println("giá trị nhập không hợp lệ! xin nhập lại");
        }
        if (!this.checkRow(r, v)) {
            System.out.println("số bạn đã nhập hàng này có rồi! xin nhập lại!");
        } else if (!this.checkColumn(c, v)) {
            System.out.println("số ban đã nhập cột này có rồi! xin nhập lại! ");
        } else if (!this.checkZone(e, v)) {
            System.out.println("số bạn đã nhập vùng này có rồi! xin nhập lại! ");
        }
        else {
//            this.addPoint(e);
            this.nodes.set(e.getRow()*9+e.getColumn(), e);
        }
    }

    public boolean checkRow(int r, int v) {
        for (int i = 0; i < nodes.size(); i++) {
            if (this.nodes.get(i).getRow() == r && this.nodes.get(i).getValue() == v) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(int c, int v) {
        for (int i = 0; i < nodes.size(); i++) {
            if (this.nodes.get(i).getColumn() == c && this.nodes.get(i).getValue() == v) {
                return false;
            }
        }
        return true;
    }

//    public void addPoint(Node e) {
//        this.nodes.add(e);
//    }

//    public void setPoint(){
//        System.out.println("nhap hang muon danh:");
//        r = sc.nextInt() - 1;
//        System.out.println("nhap cot muon danh:");
//        c = sc.nextInt() - 1;
//        System.out.println("nhap so muon danh:");
//        v = sc.nextInt();
//        int n =r*8+c;
//        Node e = new Node(r, c, v);
//        if(!this.nodes.get(n).isValidate()) {
//            System.out.println("giá trị nhập không hợp lệ! xin nhập lại");
//        }
//        if (!this.checkRow(r, v)) {
//            System.out.println("số bạn đã nhập hàng này có rồi! xin nhập lại!");
//        } else if (!this.checkColumn(c, v)) {
//            System.out.println("số ban đã nhập cột này có rồi! xin nhập lại! ");
//        } else if (!this.checkZone(e, v)) {
//            System.out.println("số bạn đã nhập vùng này có rồi! xin nhập lại! ");
//        }
//        else {
//            this.addPoint(e);
//            this.nodes.set(e.getRow()*9+e.getColumn(), e);
//        }
//    }

    public boolean checkZone(Node e, int v) {
        for (int i = 0; i < nodes.size(); i++) {
            if (e.getZone() == this.nodes.get(i).getZone() && e.getValue() == this.nodes.get(i).getValue())
                return false;
        }
        return true;
    }

    public void loadGame() throws IOException {
        Scanner sc= new Scanner(Paths.get("E:\\ki4UTC\\javaCode\\allProject\\on-school\\src\\SODOKU\\input.txt"));
        while(sc.hasNextInt()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int n = sc.nextInt();
                    nodes.add(new Node(i, j, n));
                }
            }
        }
        sc.close();
    }

    public void showGame() {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int n= nodes.get(i*9+j).getValue();
                if((j+1)%3!=0){
                    System.out.print(n+" ");}
                if((j+1)%3==0){
                    System.out.print(n+"|");
                }
            }
            if((i+1)%3==0){
                System.out.println();
                System.out.print("-----------------");
            }
            System.out.println();
        }
    }

    public boolean winGame(){
        for(int i=0;i<this.nodes.size();i++){
            if(this.nodes.get(i).getValue()==0)return false;
        }
        return true;
    }

}

