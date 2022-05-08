package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 2500;
    public static int bossDamage = 120;
    public static String bossDefence;
    public static int[] heroesHealth = {650, 450, 350, 500, 800, 1500, 400, 700};
    public static int[] heroesDamage = {40, 50, 45, 0, 80, 20, 50, 60};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Medic", "Thor", "Golem", "Lucky", "Berserk"};
    public static int round_number = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
        }

    }

    public static void round() {
        round_number++;
        bossHits();
        heroesHit();
        printStatistics();
        Medic();
        Thor();
        Lucky();
        Golem();
        Berserk();
    }

    public static void printStatistics() {
        System.out.println(round_number + "  ROUND");
        System.out.println("Boss Health:" + bossHealth + " (" + bossDamage + ")");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health:" + heroesHealth[i] + " (" + heroesDamage[i] + ")");
        }
    }


    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0 && heroesHealth[3] <= 0 && heroesHealth[4] <= 0) {
            System.out.println("Boss won!");
            return true;
        }
        return false;
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] <= 0) {

            }

            if (heroesHealth[i] - bossDamage < 0) {
                heroesHealth[i] = 0;
            } else {
                heroesHealth[i] = heroesHealth[i] - bossDamage;
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (bossHealth <= 0 || heroesHealth[i] <= 0) {
                continue;
            }
            if (bossHealth - heroesDamage[i] < 0) {
                bossHealth = 0;
            } else {

                bossHealth = bossHealth - heroesDamage[i];
            }
        }
    }

    public static void Medic() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] < 100 && heroesHealth[i] > 0) {
                if (heroesHealth[3] < 100 && heroesHealth[3] > 0) {
                    heroesHealth[3] = heroesHealth[3] - bossDamage;
                } else {

                    int rtyu = 60;
                    heroesHealth[i] = heroesHealth[i] + rtyu - bossDamage;
                    break;

                }
            }

        }

    }

    public static void Thor() {
        Random random = new Random();
        boolean stan = random.nextBoolean();
        if (stan) {
            bossDamage = 0;
        } else {
            bossDamage = 120;
        }


    }

    public static void Lucky() {

        int a = heroesHealth[6];
        int b = heroesHealth[6] - bossDamage;
        Random random = new Random();
        boolean luck = random.nextBoolean();
        if (luck) {
            heroesHealth[6] = a;
        } else {
            heroesHealth[6] = b;

        }


    }

    public static void Golem() {
        int klkl = bossDamage / 5;
        int gogo = 0;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                gogo++;
                heroesHealth[i] = heroesHealth[i] - klkl;
                heroesHealth[5] = heroesHealth[5] - gogo * klkl;

            }
        }
    }

    public static void Berserk() {
        Random random = new Random();
        int damage = random.nextInt(120);
        heroesHealth[7] = heroesHealth[7] - damage;
        heroesDamage[7] = heroesDamage[7] + damage;
    }
}
