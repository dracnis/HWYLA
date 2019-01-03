package mcp.mobius.waila.gui.config.value;

import net.minecraft.client.gui.GuiEventListener;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;

import java.util.function.Consumer;

public class OptionsEntryValueBoolean extends OptionsEntryValue<Boolean> {

    private final ButtonWidget button;

    public OptionsEntryValueBoolean(String optionName, boolean value, Consumer<Boolean> save) {
        super(optionName, save);

        this.button = new ButtonWidget(0, 0, 0, 100, 20, I18n.translate("gui." + (value ? "yes" : "no"))) {
            @Override
            public void onPressed(double mouseX, double mouseY) {
                OptionsEntryValueBoolean.this.value = !OptionsEntryValueBoolean.this.value;
            }
        };
        this.value = value;
    }

    @Override
    protected void drawValue(int entryWidth, int entryHeight, int x, int y, int mouseX, int mouseY, boolean selected, float partialTicks) {
        this.button.x = x + 135;
        this.button.y = y + entryHeight / 6;
        this.button.text = I18n.translate("gui." + (value ? "yes" : "no"));
        this.button.draw(mouseX, mouseY, partialTicks);
    }

    @Override
    public GuiEventListener getListener() {
        return button;
    }
}