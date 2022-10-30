package net.xconfig.bungee.config;

import net.md_5.bungee.config.Configuration;
import net.xconfig.enums.Action;
import net.xconfig.enums.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Interface for the ConfigurationHandler of Bungee platforms.
 *
 * @author InitSync
 * @version 1.0.1
 * @since 1.0.1
 */
public interface BungeeConfigurationHandler {
	/**
	 * Make some action with the files. Reload, Save or Write a new value.
	 *
	 * @param file File type.
	 * @param action Action type.
	 * @param toPath Path for the value.
	 * @param object Object/Value to set.
	 */
	void doSomething(
		 @NotNull File file,
		 @NotNull Action action,
		 @Nullable String toPath,
		 @Nullable Object object,
		 @Nullable String customFileName
	);
	
	/**
	 * Returns a String from path requested.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A text string.
	 */
	@NotNull String text(@NotNull File file, @NotNull String path, @Nullable String customFileName);
	
	/**
	 * Returns a integer.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A number
	 */
	int number(@NotNull File file, @NotNull String path, @Nullable String customFileName);
	
	/**
	 * Returns an object from the path.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return An object.
	 */
	@Nullable Object any(@NotNull File file, @NotNull String path, @Nullable String customFileName);
	
	/**
	 * Returns a list.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A list.
	 */
	@NotNull List<?> list(@NotNull File file, @NotNull String path, @Nullable String customFileName);
	
	/**
	 * Returns a text list.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A string list.
	 */
	@NotNull List<String> textList(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	);
	
	/**
	 * Returns a boolean.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A boolean value.
	 */
	boolean condition(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	);
	
	/**
	 * Returns a Configuration object.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A Configuration
	 */
	@Nullable Configuration section(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	);
	
	/**
	 * Returns a char from the file.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A char
	 */
	char character(@NotNull File file, @NotNull String path, @Nullable String customFileName);
}