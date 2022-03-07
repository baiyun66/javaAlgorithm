package datastruct.yuesefu;

public class yuesefu {
    public static void main(String[] args) {
        BoyList boylist = new BoyList();

        for (int i = 1; i < 15; i++) {
            boylist.add(i);
        }
        boylist.list();
        boylist.popBoy(4);


    }
}

class BoyList {
    private Boy first = null;

    public void add(int num) {
        if (num < 0) {
            System.out.println("num小于0");
            return;
        }
        if (first == null) {
            first = new Boy(num);
            first.setNext(first);
            return;
        }
        Boy currentBoy = first;
        while (currentBoy.getNext() != first) {
            currentBoy = currentBoy.getNext();
        }
        Boy boy = new Boy(num);
        currentBoy.setNext(boy);
        boy.setNext(first);
    }

    public void list() {
        if (first == null) {
            System.out.println("没有值");
            return;
        }
        Boy currentBoy = first;
        while (currentBoy.getNext() != first) {
            System.out.printf("%d->", currentBoy.getNo());
            currentBoy = currentBoy.getNext();
        }
        System.out.printf("%d\n", currentBoy.getNo());
    }

    public int getLength() {
        if (first == null) {
            System.out.println("没有值");
            return 0;
        }
        Boy currentBoy = first;
        int len_ = 1;
        while (currentBoy.getNext() != first) {
            len_++;
            currentBoy = currentBoy.getNext();
        }
        return len_;
    }

//    public void popBoy(int num) {
//        if (num > getLength()) {
//            System.out.println("没有值");
//            return;
//        }
//        Boy currentBoy = first;
//        System.out.printf("len:%d\n", getLength());
//        int k = 0;
//        int index = 0;
//        while (k < getLength()) {
//            if (currentBoy.getNo() > 0) {
//                index++;
//            }
//            if (index == num) {
//                System.out.printf("%d->", currentBoy.getNo());
//                index = 0;
//                currentBoy.setNo(-1);
//                k++;
//            }
//            currentBoy = currentBoy.getNext();
//        }
//        System.out.println();
//        list();
//    }

    public void popBoy(int num) {
        if (num > getLength() || num == 0) {
            System.out.println("出错了！");
            return;
        }
        Boy currentBoy = first;
        Boy helper = currentBoy;
        while(helper.getNext()!=currentBoy)
        {
            helper = helper.getNext();
        }
        while (true) {
          if(currentBoy== helper)
          {
              break;
          }
          for(int i =0;i<num-1;i++){
              currentBoy = currentBoy.getNext();
              helper = helper.getNext();
          }
          System.out.printf("%d->",currentBoy.getNo());
          currentBoy = currentBoy.getNext();
          helper.setNext(currentBoy);
        }
        System.out.printf("%d",currentBoy.getNo());
    }

}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public void setNext(Boy boy) {
        this.next = boy;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return this.next;
    }

    public int getNo() {
        return this.no;
    }

}