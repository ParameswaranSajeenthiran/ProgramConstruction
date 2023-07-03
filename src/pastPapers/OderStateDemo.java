package pastPapers;

import java.util.ArrayList;
import java.util.List;

public class OderStateDemo {


}



class Order{

    private OrderState orderState;
    public Order (){
        orderState=new OpenOrder();

    }

    public void setOrderState(OrderState orderState){
        this.orderState = orderState;

    }


    public void cancel() {
        orderState.cancel(this);

    }


    public void approve() {
        orderState.approve(this);

    }


    public void sendForApproval() {
        orderState.sendForApproval(this);


    }


    public void shipped() {
        orderState.shipped(this);

    }





}

interface OrderState {
    public void cancel(Order order);
    public void approve(Order order);

    public void sendForApproval(Order order);


    public void shipped(Order order);


}


class OpenOrder implements  OrderState{


    @Override
    public void cancel(Order order) {

    }

    @Override
    public void approve(Order order) {

    }

    @Override
    public void sendForApproval(Order order) {
        order.setOrderState(new ApprovalState());

    }

    @Override
    public void shipped(Order order) {

    }
}

class ApprovalState implements  OrderState {

    @Override
    public void cancel(Order order) {

    }

    @Override
    public void approve(Order order) {
        order.setOrderState(new ShippingState());


    }

    @Override
    public void sendForApproval(Order order) {

    }

    @Override
    public void shipped(Order order) {

    }
}

class ShippingState implements  OrderState {

    @Override
    public void cancel(Order order) {

    }

    @Override
    public void approve(Order order) {

    }

    @Override
    public void sendForApproval(Order order) {

    }

    @Override
    public void shipped(Order order) {
        order.setOrderState(new InvoiceState());

    }
}
class InvoiceState implements  OrderState{

    @Override
    public void cancel(Order order) {
        System.out.println("cannot cancel");
    }

    @Override
    public void approve(Order order) {

    }

    @Override
    public void sendForApproval(Order order) {

    }

    @Override
    public void shipped(Order order) {

    }
}

class Test1{
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(new Integer(2));
        list.add( new Integer(3));
        System.out.println(list);

    }
}