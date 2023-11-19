package model.scheduler;

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
                    Thread.sleep(400);
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
