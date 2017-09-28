public class TestIoUtils {
	public static void main(String[] args) {
		String sourceFile = "/home/shoghiktatevosyan/Desktop/my projects/Apload";
		String sourceFile1 = "/home/shoghiktatevosyan/Desktop/test/text.txt";
		String destPath = "/home/shoghiktatevosyan/Desktop/test1/text.txt";
		IoUtils ioUtils = new IoUtils();
		ioUtils.showFolderHierarchy(sourceFile);
		ioUtils.returnByteArray(sourceFile1);
		ioUtils.copyFile(sourceFile1, destPath);
		ioUtils.copyFileOtherVersion(sourceFile1, destPath);
		ioUtils.moveFile(sourceFile1, destPath);
		ioUtils.deleteFileByPath(destPath);
	}
}
