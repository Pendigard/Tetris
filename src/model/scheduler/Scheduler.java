package model.scheduler;

import view.theme.Theme;

public class Scheduler extends Thread {

        public Runnable runnable;
        private int tickElapsed = 0;

        public Scheduler(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    if (tickElapsed == 0)
                        Thread.sleep(400); // At the beginning, we wait 400ms for the window to be displayed
                    else
                        Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickElapsed++;
                System.out.println(tickElapsed);
                runnable.run();
            }
        }

        public int getTickElapsed() {
            return tickElapsed;
        }
}
