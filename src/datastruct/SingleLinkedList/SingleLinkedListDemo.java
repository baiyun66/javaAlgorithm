package datastruct.SingleLinkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1,"松江","及时雨");
        HeroNode hero2 = new HeroNode(5,"松江","及时雨");
        HeroNode hero3 = new HeroNode(4,"松江","及时雨");
        HeroNode hero4 = new HeroNode(2,"松江","及时雨");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.add_sort(hero1);
        singleLinkedList.add_sort(hero2);
        singleLinkedList.add_sort(hero3);
        singleLinkedList.add_sort(hero4);
        HeroNode hero5 = new HeroNode(6,"林冲","豹子头");
        singleLinkedList.update(hero5);

        singleLinkedList.list();

        singleLinkedList.delete(hero3);
        singleLinkedList.list();

        System.out.println(singleLinkedList.get_length(singleLinkedList.getHeadNode()));


        singleLinkedList.reversList();
        singleLinkedList.list();


    }

}

class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public void add(HeroNode heroNode){
        HeroNode temp = head;

        while (true){
            if(temp.next == null){
                temp.next = heroNode;
                break;
            }else {
                temp = temp.next;
            }
        }
        heroNode.next = null;
    }
    public HeroNode getHeadNode(){
      return head;
    }




    public void add_sort(HeroNode heroNode){
        HeroNode temp = head;

        while (true){
            if(temp.next == null){
                temp.next = heroNode;
                heroNode.next = null;
                break;
            } else if(temp.next.no>heroNode.no){
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }else if(temp.next.no==heroNode.no){
                System.out.println("已经有该英雄！"+String.valueOf(heroNode.no));
                break;
            }else {
                temp = temp.next;
            }
        }
    }


    public void list(){
        HeroNode temp = head;
        if(temp.next == null){
            System.out.println("数据为空！");
        }else {
            while (true){
                if(temp.next == null){
                    break;
                }else {
                    temp = temp.next;
                    System.out.println(String.valueOf(temp.no)+temp.name+temp.nickname);
                }
            }
        }
        }

    public void update(HeroNode heroNode){
        HeroNode temp = head;
        if(temp.next == null){
            System.out.println("数据为空！");
        }else {
            while (true){
                if(temp.next == null){
                    System.out.println("没有该节点！");
                    break;
                }else if(temp.next.no == heroNode.no){
                    heroNode.next = temp.next.next;
                    temp.next = heroNode;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }
    }


    public void delete(HeroNode heroNode){
        HeroNode temp = head;
        if(temp.next == null){
            System.out.println("数据为空！");
        }else {
            while (true){
                if(temp.next == null){
                    System.out.println("没有该节点！");
                    break;
                }else if(temp.next.no == heroNode.no){
                    temp.next = temp.next.next;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }
    }

    public  int get_length( HeroNode headNode){
        HeroNode temp = headNode;
        int len = 0;
        while (true){
            if(temp.next == null){
                break;
            }else {
                len++;
                temp = temp.next;
            }
        }
        return len;
    }

    public  void reversList(){
        if(head.next == null || head.next.next == null){
            return;
        }
        HeroNode temp = head.next.next;
        HeroNode p = head.next;
        while (true){
            if(p.next == null){
                break;
            }else{
                p.next = temp.next;
                temp.next = head.next;
                head.next = temp;
                temp = p.next;
            }
        }
    }




}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }
}