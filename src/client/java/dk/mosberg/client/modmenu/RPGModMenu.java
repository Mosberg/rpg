package dk.mosberg.client.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.minecraft.client.gui.screen.Screen;

/**
 * Mod Menu integration entrypoint for RPG mod.
 */
public class RPGModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
        return RPGConfigScreen::new;
    }
}
