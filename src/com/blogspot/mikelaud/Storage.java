package com.blogspot.mikelaud;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Storage {

	private final long BUFFER_SIZE_B = 1000;
	//
	private RandomAccessFile mRandomAccessFile = null;
	private FileChannel mFileChannel = null;
	private MappedByteBuffer mBuffer = null;
	
	public boolean isClosed() {
		return (null == mBuffer || null == mFileChannel || null == mRandomAccessFile);
	}
	
	public boolean isOpen() {
		return ! this.isClosed();
	}
	
	public void save() {
		if (null != mBuffer) {
			mBuffer.force();
		}
	}
	
	public void close() throws Exception {
		mBuffer = null;
		if (null != mFileChannel) {
			try {
				mFileChannel.close();
				mFileChannel = null;
			}
			finally {
				if (null != mRandomAccessFile) {
					mRandomAccessFile.close();
					mRandomAccessFile = null;
				}
			}
		}
	}
	
	public boolean open() throws Exception {
		File file = new File(Settings.getFileName());
		mRandomAccessFile = new RandomAccessFile(file, "rw");
		mFileChannel = mRandomAccessFile.getChannel();
		mBuffer = mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE_B);
		return this.isOpen();
	}
	
	public Storage() {
		// void
	}
	
}
