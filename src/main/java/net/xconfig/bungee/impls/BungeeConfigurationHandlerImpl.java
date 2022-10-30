package net.xconfig.bungee.impls;

import net.md_5.bungee.config.Configuration;
import net.xconfig.bungee.config.BungeeConfigurationHandler;
import net.xconfig.bungee.config.BungeeConfigurationModel;
import net.xconfig.enums.Action;
import net.xconfig.enums.File;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Implementation to handle the values from the configuration at BungeeCord platforms.
 *
 * @author InitSync
 * @version 1.0.1
 * @since 1.0.1
 */
public final class BungeeConfigurationHandlerImpl implements BungeeConfigurationHandler {
	private final BungeeConfigurationModel configuration;
	
	public BungeeConfigurationHandlerImpl(@NotNull BungeeConfigurationModel configuration) {
		this.configuration = Objects.requireNonNull(configuration, "The ConfigurationModel is null.");
	}
	
	/**
	 * Make some action with the files. Reload, Save or Write a new value.
	 *
	 * @param file           File type.
	 * @param action         Action type.
	 * @param toPath         Path for the value.
	 * @param object         Object/Value to set.
	 * @param customFileName
	 */
	@Override
	public void doSomething(
		 @NotNull File file,
		 @NotNull Action action,
		 @Nullable String toPath,
		 @Nullable Object object,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Objects.requireNonNull(action, "The action type is null.");
		
		switch (file) {
			case CONFIG:
				switch (action) {
					case RELOAD:
						this.configuration.reload("config.yml");
						break;
					case SAVE:
						this.configuration.save("config.yml");
						break;
					case WRITE:
						assert toPath != null;
						this.configuration
							 .file("config.yml")
							 .set(toPath, object);
						break;
				}
				break;
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				switch (action) {
					case RELOAD:
						this.configuration.reload(customFileName);
						break;
					case SAVE:
						this.configuration.save(customFileName);
						break;
					case WRITE:
						assert toPath != null;
						this.configuration
							 .file(customFileName)
							 .set(toPath, object);
						break;
				}
				break;
		}
	}
	
	/**
	 * Returns a String from path requested.
	 *
	 * @param file           File type.
	 * @param path           Path required.
	 * @param customFileName Name of the custom file.
	 * @return A text string.
	 */
	@Override
	public @NotNull String text(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .getString(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .getString(path);
		}
		return "";
	}
	
	/**
	 * Returns a integer.
	 *
	 * @param file           File type.
	 * @param path           Path required.
	 * @param customFileName Name of the custom file.
	 * @return A number
	 */
	@Override
	public int number(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .getInt(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .getInt(path);
		}
		return 0;
	}
	
	/**
	 * Returns an object from the path.
	 *
	 * @param file           File type.
	 * @param path           Path required.
	 * @param customFileName Name of the custom file.
	 * @return An object.
	 */
	@Override
	public @Nullable Object any(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .get(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .get(path);
		}
		return null;
	}
	
	/**
	 * Returns a list.
	 *
	 * @param file           File type.
	 * @param path           Path required.
	 * @param customFileName Name of the custom file.
	 * @return A list.
	 */
	@Override
	public @NotNull List<?> list(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .getList(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .getList(path);
		}
		return Collections.emptyList();
	}
	
	/**
	 * Returns a text list.
	 *
	 * @param file           File type.
	 * @param path           Path required.
	 * @param customFileName Name of the custom file.
	 * @return A string list.
	 */
	@Override
	public @NotNull List<String> textList(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .getStringList(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .getStringList(path);
		}
		return Collections.emptyList();
	}
	
	/**
	 * Returns a boolean.
	 *
	 * @param file           File type.
	 * @param path           Path required.
	 * @param customFileName Name of the custom file.
	 * @return A boolean value.
	 */
	@Override
	public boolean condition(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .getBoolean(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .getBoolean(path);
		}
		return false;
	}
	
	/**
	 * Returns a Configuration object.
	 *
	 * @param file           File type.
	 * @param path           Path required.
	 * @param customFileName Name of the custom file.
	 * @return A Configuration
	 */
	@Override
	public @Nullable Configuration section(
		 @NotNull File file,
		 @NotNull String path,
		 @Nullable String customFileName
	) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .getSection(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .getSection(path);
		}
		return null;
	}
	
	/**
	 * Returns a char from the file.
	 *
	 * @param file File type.
	 * @param path Path required.
	 * @param customFileName Name of the custom file.
	 * @return A char
	 */
	@Override
	public char character(@NotNull File file, @NotNull String path, @Nullable String customFileName) {
		Objects.requireNonNull(file, "The file type is null.");
		Validate.notEmpty(path, "The path to get is empty.");
		
		switch (file) {
			case CONFIG:
				return this.configuration
					 .file("config.yml")
					 .getChar(path);
			case CUSTOM:
				assert customFileName != null && !customFileName.isEmpty();
				return this.configuration
					 .file(customFileName)
					 .getChar(path);
		}
		return 0;
	}
}
