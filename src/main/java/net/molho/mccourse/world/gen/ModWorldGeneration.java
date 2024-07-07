package net.molho.mccourse.world.gen;

public class ModWorldGeneration {

    public static void generateModWorldGeneration(){
        ModOreGeneration.generateOres(); //Needs come before the trees
        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
    }
}
