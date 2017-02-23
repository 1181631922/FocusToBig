package com.fanyafeng.focustobig.mytest;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author： fanyafeng
 * Data： 17/2/23 下午5:39
 * Email: fanyafeng@live.cn
 */
public class MyTest01 {

    static class A implements Parcelable, Comparable<A> {
        private String b;//去重字段
        private String c;//排序字段

        public A() {
        }

        public A(String b, String c) {
            this.b = b;
            this.c = c;
        }

        protected A(Parcel in) {
            b = in.readString();
            c = in.readString();
        }

        public static final Creator<A> CREATOR = new Creator<A>() {
            @Override
            public A createFromParcel(Parcel in) {
                return new A(in);
            }

            @Override
            public A[] newArray(int size) {
                return new A[size];
            }
        };

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "A{" +
                    "b='" + b + '\'' +
                    ", c='" + c + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(b);
            dest.writeString(c);
        }

        @Override
        public int compareTo(A o) {
            if (this.b.equals(o.getB())) {
                return 0;
            } else {
                return this.c.compareTo(o.getC()) == 0 ? this.b.compareTo(o.getB()) : this.c.compareTo(o.getC());
            }
//            return this.b.compareTo(o.getB());
        }
    }


    public static void main(String[] args) {
        Set<A> aSet = new TreeSet<>();

        aSet.add(new A("h", "j"));
        aSet.add(new A("g", "j"));
        aSet.add(new A("f", "i"));
        aSet.add(new A("e", "h"));
        aSet.add(new A("d", "g"));
        aSet.add(new A("c", "f"));
        aSet.add(new A("b", "e"));
        aSet.add(new A("a", "d"));
        aSet.add(new A("a", "c"));
        aSet.add(new A("a", "b"));

        System.out.println("size" + aSet.size());
        List<A> aList = new ArrayList<>(aSet);

        for (int i = 0; i < aList.size(); i++) {
            System.out.println("开始打印：" + aList.get(i));
        }

        System.out.println("-----------我是分割线-------------");

        Collections.sort(aList, new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o1.getC().compareTo(o2.getC());
            }
        });

        for (int i = 0; i < aList.size(); i++) {
            System.out.println("开始打印：" + aList.get(i));
        }

        List<A> aList1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            A a = new A(String.valueOf(i), String.valueOf(i % 10));
            A a2 = new A(String.valueOf(i), String.valueOf(i % 10));
            aList1.add(a);
            aList1.add(a2);
        }

        System.out.println("-----------我是分割线-------------");

        Set<A> aSet1 = new TreeSet<>(aList1);
        for (A a : aSet1) {
            System.out.println("开始打印：" + a.toString());
        }


    }
}
