package me.online.Utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Lang {

	/*
	 * This class is used to make the messages for this plugin 100% customizable using the lang.yml
	 */
	TITLE("title-name", "&4[&fPlayerVaults&4]:"),
    OPEN_VAULT("open-vault", "&fOpening vault &a%v"),
    OPEN_OTHER_VAULT("open-other-vault", "&fOpening vault &a%v &fof &a%p"),
    OPEN_WORKBENCH("open-workbench", "&fOpening workbench"),
    INVALID_ARGS("invalid-args", "&cInvalid args!"),
    DELETE_VAULT("delete-vault", "&fDeleted vault &a%v"),
    DELETE_OTHER_VAULT("delete-other-vault", "&fDeleted vault &a%v &fof &a%p"),
    PLAYER_ONLY("player-only", "Sorry but that can only be run by a player!"),
    MUST_BE_NUMBER("must-be-number", "&cYou need to specify a number between 1-99"),
    DELETE_VAULT_ERROR("delete-vault-error", "&cError deleting vault :("),
    NO_PERMS("no-permissions", "&cYou don''t have permission for that!"),
    INSUFFICIENT_FUNDS("insufficient-funds", "&cYou don''t have enough money for that!"),
    REFUND_AMOUNT("refund-amount", "&fYou were refunded &a%price &ffor deleting that vault."),
    COST_TO_CREATE("cost-to-create", "&fYou were charged &c%price &ffor creating a vault."),
    COST_TO_OPEN("cost-to-open", "&fYou were charged &c%price &ffor opening that vault."),
    VAULT_DOES_NOT_EXIST("vault-does-not-exist", "&cThat vault does not exist!"),
    CLICK_A_SIGN("click-a-sign", "&fNow click a sign!"),
    NOT_A_SIGN("not-a-sign", "&cYou must click a sign!"),
    SET_SIGN("set-sign-success", "&fYou have successfully set a PlayerVault access sign!"),
    EXISTING_VAULTS("existing-vaults", "&f%p has vaults: &a%v"),
    VAULT_TITLE("vault-title", "&4Vault #%number"),
    OPEN_WITH_SIGN("open-with-sign", "&fOpening vault &a%v &fof &a%p");

    private String path;
    private String def;
    private static YamlConfiguration LANG;

    /**
     * Lang enum constructor.
     *
     * @param path The string path.
     * @param start The default string.
     */
    Lang(String path, String start) {
        this.path = path;
        this.def = start;
    }

    /**
     * Set the {@code YamlConfiguration} to use.
     *
     * @param config The config to set.
     */
    public static void setFile(YamlConfiguration config) {
        LANG = config;
    }

    @Override
    public String toString() {
        if (this == TITLE)
            return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def)) + " ";
        return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def));
    }

    /**
     * Get the default value of the path.
     *
     * @return The default value of the path.
     */
    public String getDefault() {
        return this.def;
    }

    /**
     * Get the path to the string.
     *
     * @return The path to the string.
     */
    public String getPath() {
        return this.path;
    }

}
