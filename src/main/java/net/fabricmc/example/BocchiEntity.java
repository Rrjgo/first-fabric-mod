package net.fabricmc.example;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class BocchiEntity  extends PathAwareEntity {

    public BocchiEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }



}
