package leetcode;

import org.junit.Test;

public  class Solution203 {
    class ListNode {
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(this.val+"");
            ListNode temp=this;
            while (temp.next!=null){
                stringBuilder.append("->"+temp.next.val);
                temp=temp.next;
            }
            return stringBuilder.toString();
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null)
            return null;
        ListNode prev = head;
        while (prev.next!=null){
            if(prev.next.val==val)
                prev.next=prev.next.next;
            else
                prev=prev.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1,head);
        ListNode prev = fakeHead;
        while (prev.next!=null){
            if(prev.next.val==val)
                prev.next=prev.next.next;
            else
                prev=prev.next;
        }
        return fakeHead.next;
    }

    public ListNode removeElements3(ListNode head, int val) {
       if(head==null)
           return null;
        ListNode res = removeElements3(head.next, val);//因为这里传的是head.next,所以下面才是head.next=res,相当于跳过一节点.
        if(head.val==val){
            return res;
        }
        else {
            head.next=res;
        }
        return head;
    }

    public ListNode removeElements4(ListNode head, int val) {
//        removeElements4()
        return null;
    }

    @Test
    public void test() {
        ListNode listNode=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,null))))));
        System.out.println(        this.removeElements(listNode,6));
        System.out.println(        this.removeElements2(listNode,6));
        System.out.println(        this.removeElements3(listNode,6));
    }
}