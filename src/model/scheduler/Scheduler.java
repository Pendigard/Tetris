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
                        Thread.sleep(1000); // At the beginning, we wait 1000ms for the window to be displayed
                    else
                        Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickElapsed++;
                runnable.run();
            }
        }

        public int getTickElapsed() {
            return tickElapsed;
        }
}
