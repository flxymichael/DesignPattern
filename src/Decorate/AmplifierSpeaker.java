package Decorate;

/**
 * 装饰器模式
 * 人、扩音器实现接口speak
 * 扩音器中有属性：人
 * 人利用扩音器完成扩音
 */
public class AmplifierSpeaker {
    public static void main(String[] args) {
        Person person = new Person(100);
        person.say();

        Amplifier amplifier = new Amplifier(person);
        amplifier.say();
    }
}

interface Speak {
    void say();
}

class Person implements Speak {
    private int voice;

    @Override
    public void say() {
        System.out.println(voice + "分贝");
    }

    public Person(int voice) {
        this.voice = voice;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Speak {
    private Person person;

    public Amplifier(Person person) {
        this.person = person;
    }

    @Override
    public void say() {
        System.out.println("调用了扩音器:" + person.getVoice() * 100 + "分贝");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

