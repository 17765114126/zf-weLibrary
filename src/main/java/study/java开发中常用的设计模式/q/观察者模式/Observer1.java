package study.java开发中常用的设计模式.q.观察者模式;


public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}