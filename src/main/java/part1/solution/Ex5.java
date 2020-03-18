package part1.solution;

class Keyboard {
    char read() {
        return 1;
    }
}

interface IDevice{
    void print(char read);
}

class Printer implements IDevice{
    @Override
    public void print(char read) {
        System.out.print(read);
    }
}

class Device implements  IDevice{
    @Override
    public void print(char read) {
        System.out.print(read);
    }
}

class OutputDevice {
    void copy(IDevice device) {
        Keyboard keyboard = new Keyboard();
        char character;
        while ((character = keyboard.read()) != -1) {
            device.print(character);
        }
    }
}
