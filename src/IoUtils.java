
import java.io.*;
import java.nio.file.Files;
import java.util.logging.Logger;

public class IoUtils {
	Logger logger = Logger.getLogger(IoUtils.class.getName());

	public void copyFile(String source, String desPath) {
		File sourceFile = new File(source);
		File destPath = new File(desPath);
		if (sourceFile.canExecute() && sourceFile.exists() && sourceFile.canRead()) {
			try {
				Files.copy(sourceFile.toPath(), destPath.toPath());
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("Cannot finde source file or destination Paht.");
			}
		} else
			System.out.println("Can not read  or execute file");
	}

	public void deleteFileByPath(String source) {
		File file = new File(source);
		if (file.canExecute() && file.exists() && file.canRead()) {
			file.delete();
		} else {
			System.out.println("Can not  execute file");
		}
	}

	public void moveFile(String source, String desPath) {
		File sourceFile = new File(source);
		File destFile = new File(desPath);
		if (sourceFile.canExecute() && sourceFile.exists() && sourceFile.canRead()) {
			try (InputStream inputStream = new FileInputStream(sourceFile);
					 OutputStream outputStream = new FileOutputStream(destFile)) {
				int data = 0;
				byte[] buffer = new byte[4096];
				while ((data = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, data);
				}
			} catch (IOException e) {
				logger.info("Cannot finde source or destination path." + e);
			}
			sourceFile.delete();
		} else {
			System.out.println("Can not  execute file");
		}
	}

	public void copyFileOtherVersion(String fileSourcePath, String destPath) {
		File sourceFile = new File(fileSourcePath);
		File destFile = new File(destPath);
		if (sourceFile.canExecute() && sourceFile.exists() && sourceFile.canRead()) {
			try (InputStream inputStream = new FileInputStream(fileSourcePath);
					 OutputStream outputStream = new FileOutputStream(destPath)) {
				int data = 0;
				byte[] buffer = new byte[4096];
				while ((data = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, data);
				}
			} catch (IOException e) {
				logger.info("Cannot finde source file." + e);
			}
		} else {
			System.out.println("Can not  execute file");
		}
	}

	public void showFolderHierarchy(String folderPath) {
		StringBuilder str = new StringBuilder();
		File folder = new File(folderPath);
		if (folder.canExecute() && folder.isDirectory() && folder.canRead()) {
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (!file.isDirectory()) {
					System.out.println(file.getName());
				} else {
					System.out.println(str.append(" ") + file.getName());
					showFolderHierarchy(file.getPath());
				}
			}
		}
	}

	public byte[] returnByteArray(String filePath) {
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			File file = new File(filePath);
			if (file.canExecute() && file.exists() && file.canRead()) {
				byteArrayOutputStream = new ByteArrayOutputStream();
				InputStream inputStream = new FileInputStream(file);
				byte[] buffer = new byte[4096];
				int byteCount = 0;
				while ((byteCount = inputStream.read(buffer)) != -1) {
					byteArrayOutputStream.write(buffer, 0, byteCount);
				}

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Cannot finde source file." + e);
		}
		System.out.println(byteArrayOutputStream.toByteArray());
		return byteArrayOutputStream.toByteArray();
	}
}
