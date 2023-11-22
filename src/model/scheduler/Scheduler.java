package model.scheduler;

import view.theme.Theme;

public class Scheduler extends Thread {

        public Runnable runnable;
        private int tickElapsed = 0;

        private int refreshRate = 100;

        public Scheduler(Runnable runnable, int refreshRate) {
            this.runnable = runnable;
            this.refreshRate = refreshRate;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    if (tickElapsed == 0)
                        Thread.sleep(1000); // At the beginning, we wait 1000ms for the window to be displayed
                    else
                        Thread.sleep(refreshRate);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickElapsed++;
                runnable.run();
            }
        }

        public int getMsElapsed() {
            return tickElapsed*refreshRate;
        }
}
