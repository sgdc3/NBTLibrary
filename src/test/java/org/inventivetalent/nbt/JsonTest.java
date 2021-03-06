package org.inventivetalent.nbt;

import com.google.gson.JsonElement;
import org.inventivetalent.nbt.stream.NBTInputStream;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class JsonTest {

	@Test
	public void toJsonTest() throws Exception {
		try (NBTInputStream in = new NBTInputStream(StreamTest.class.getResourceAsStream("/bigtest.nbt"), true)) {
			NBTTag nbtTag = in.readNBTTag();
			System.out.println(nbtTag);

			JsonElement json = nbtTag.asJson();
			System.out.println(json);

			assertNotNull(json);
		}
	}

}
