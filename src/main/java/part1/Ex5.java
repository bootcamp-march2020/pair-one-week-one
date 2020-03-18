package part1;

class Keyboard {
    char read() {
        return 1;
    }
}

class OutputDevice {
    void copy(String device) {
        Keyboard keyboard = new Keyboard();
        int character;
        while ((character = keyboard.read()) != -1) {
            if (device.equals("Printer")) {
                writeToPrinter(character);
            } else {
                writeToDevice(character);
            }
        }
    }

    private void writeToDevice(int character) {
        // TODO Auto-generated method stub
    }

    private void writeToPrinter(int c) {
        // TODO Auto-generated method stub
    }
}
