package simplepets.brainsynder.api.pet.data;

import lib.brainsynder.item.ItemBuilder;
import org.bukkit.Material;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.api.entity.ambient.IEntityArmorStandPet;
import simplepets.brainsynder.api.entity.misc.IEntityControllerPet;
import simplepets.brainsynder.api.pet.PetData;

@Namespace(namespace = "persist")
public class PersistData extends PetData {
    public PersistData() {
        addDefaultItem("true", new ItemBuilder(Material.NETHER_STAR)
                .withName("&#c8c8c8{name}: &atrue"));
        addDefaultItem("false", new ItemBuilder(Material.SKELETON_SKULL)
                .withName("&#c8c8c8{name}: &cfalse"));
    }

    @Override
    public Object getDefaultValue() {
        return false;
    }

    @Override
    public void onLeftClick(IEntityPet entity) {
        entity.setPersist(!entity.shouldPersist());
    }

    @Override
    public Object value(IEntityPet entity) {
        return entity.shouldPersist();
    }

    @Override
    public boolean isModifiable(IEntityPet entity) {
        if (entity instanceof IEntityControllerPet controller) {
            controller.getVisibleEntity().setPersist(!controller.getVisibleEntity().shouldPersist());
            return false;
        }
        if (entity instanceof IEntityArmorStandPet) return false;
        return super.isModifiable(entity);
    }
}
