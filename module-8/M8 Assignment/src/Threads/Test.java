
new Thread(() -> {
        try {
        Thread.sleep(5000);
        javafx.application.Platform.runLater(() -> {
int length = textArea.getText().length();
            System.out.println("Total characters: " + length);
        });
                } catch (InterruptedException e) {
        e.printStackTrace();
    }
            }).start();
