
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 50;
    private static final int ENEMY_SIZE = 30;
    private static final int BULLET_SIZE = 5;
    private static final int BULLET_SPEED = 10;
    private static final int ENEMY_SPEED = 5;

    private Canvas canvas;
    private GraphicsContext gc;
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();
    private int score = 0;
    private Image img = new Image("D:\\GitHub\\ProgMeth\\ShipHide\\res\\map_structure.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gun Game");

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setFill(Color.AQUAMARINE);
        
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

        player = new Player(WIDTH / 2, HEIGHT / 2);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                player.moveLeft();
            } else if (event.getCode() == KeyCode.RIGHT) {
                player.moveRight();
            } else if (event.getCode() == KeyCode.UP) {
                player.moveUp();
            } else if (event.getCode() == KeyCode.DOWN) {
                player.moveDown();
            } else if (event.getCode() == KeyCode.SPACE) {
                shoot();
            }
        });

        generateEnemies();

        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(this::runGameLoop).start();
    }

    private void runGameLoop() {
        while (true) {
            update();
            draw();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        updatePlayer();
        updateEnemies();
        updateBullets();
        checkCollisions();
    }

    private void updatePlayer() {
        player.update();
        if (player.getX() < 0) {
            player.setX(0);
        } else if (player.getX() + PLAYER_SIZE > WIDTH) {
            player.setX(WIDTH - PLAYER_SIZE);
        }
        if (player.getY() < 0) {
            player.setY(0);
        } else if (player.getY() + PLAYER_SIZE > HEIGHT) {
            player.setY(HEIGHT - PLAYER_SIZE);
        }
    }

    private void updateEnemies() {
        for (Enemy enemy : enemies) {
            enemy.update();
            if (enemy.getX() < 0) {
                enemy.setX(0);
//                enemy.reverseXVelocity();
            } else if (enemy.getX() + ENEMY_SIZE > WIDTH) {
                enemy.setX(WIDTH - ENEMY_SIZE);
//                enemy.reverseXVelocity();
            }
            if (enemy.getY() < 0) {
                enemy.setY(0);
//                enemy.reverseYVelocity();
            } else if (enemy.getY() + ENEMY_SIZE > HEIGHT) {
                enemy.setY(HEIGHT - ENEMY_SIZE);
//                enemy.reverseYVelocity();
            }
        }
    }
    
    private void updateBullets() {
        List<Bullet> bulletsToRemove = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.update();
            if (bullet.getX() < 0 || bullet.getX() > WIDTH || bullet.getY() < 0 || bullet.getY() > HEIGHT) {
                bulletsToRemove.add(bullet);
            }
        }
        bullets.removeAll(bulletsToRemove);
    }

    private void checkCollisions() {
        List<Enemy> enemiesToRemove = new ArrayList<>();
        List<Bullet> bulletsToRemove = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (player.intersects(enemy)) {
                gameOver();
            }
            for (Bullet bullet : bullets) {
                if (bullet.intersects(enemy)) {
                    enemiesToRemove.add(enemy);
                    bulletsToRemove.add(bullet);
                    score++;
                }
            }
        }
        enemies.removeAll(enemiesToRemove);
        bullets.removeAll(bulletsToRemove);
    }

    private void gameOver() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(Color.RED);
        gc.fillText("GAME OVER", WIDTH / 2 - 50, HEIGHT / 2);
    }

    private void draw() {
        gc.setFill(new ImagePattern(img));
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setFill(Color.BLUE);
        gc.fillRect(player.getX(), player.getY(), PLAYER_SIZE, PLAYER_SIZE);

//        gc.setFill(Color.RED);
//        for (Enemy enemy : enemies) {
//            gc.fillRect(enemy.getX(), enemy.getY(), ENEMY_SIZE, ENEMY_SIZE);
//        }

        gc.setFill(Color.WHITE);
        for (Bullet bullet : bullets) {
            gc.fillRect(bullet.getX(), bullet.getY(), BULLET_SIZE, BULLET_SIZE);
        }

        gc.setFill(Color.GREEN);
        gc.fillText("Score: " + score, 10, 20);
    }

    private void shoot() {
    	
        Bullet bullet = new Bullet(player.getX() + PLAYER_SIZE / 2 - BULLET_SIZE / 2, player.getY() - BULLET_SIZE);
        bullets.add(bullet);
    }

    private void generateEnemies() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Enemy enemy = new Enemy(random.nextInt(WIDTH - ENEMY_SIZE), random.nextInt(HEIGHT - ENEMY_SIZE));
            enemies.add(enemy);
        }
    }

    private static class Player {
        private double x;
        private double y;

        public Player(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void moveLeft() {
            x -= 10;
        }

        public void moveRight() {
            x += 10;
        }

        public void moveUp() {
            y -= 10;
        }

        public void moveDown() {
            y += 10;
        }

        public void update() {
            // Do nothing for now
        }

        public boolean intersects(Enemy enemy) {
            return x < enemy.getX() + ENEMY_SIZE &&
                    x + PLAYER_SIZE > enemy.getX() &&
                    y < enemy.getY() + ENEMY_SIZE &&
                    y + PLAYER_SIZE > enemy.getY();
        }
    }
    
    private static class Enemy {
        private double x;
        private double y;
        private double xVelocity = ENEMY_SPEED;
        private double yVelocity = ENEMY_SPEED;

        public Enemy(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void update() {
            x += xVelocity;
            y += yVelocity;

            if (x < 0 || x > WIDTH - ENEMY_SIZE) {
                xVelocity *= -1;
            }

            if (y < 0 || y > HEIGHT - ENEMY_SIZE) {
                yVelocity *= -1;
            }
        }

        public boolean intersects(Bullet bullet) {
            return x < bullet.getX() + BULLET_SIZE &&
                    x + ENEMY_SIZE > bullet.getX() &&
                    y < bullet.getY() + BULLET_SIZE &&
                    y + ENEMY_SIZE > bullet.getY();
        }
    }

    private static class Bullet {
        private double x;
        private double y;
        private double yVelocity = -BULLET_SPEED; // set initial y-velocity to move upward

        public Bullet(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void update() {
        	Random random = new Random();
        	
            y += yVelocity; // add the y-velocity to the current y-position
            x += xVelocity;

            if (y < 0) { // if the bullet goes off the top of the screen
                yVelocity = -yVelocity; // reverse the y-velocity to make it move downward
                y += yVelocity; // move the bullet back onto the screen
            }
        }

        public boolean intersects(Enemy enemy) {
            return x < enemy.getX() + ENEMY_SIZE &&
                    x + BULLET_SIZE > enemy.getX() &&
                    y < enemy.getY() + ENEMY_SIZE &&
                    y + BULLET_SIZE > enemy.getY();
        }
    }
}