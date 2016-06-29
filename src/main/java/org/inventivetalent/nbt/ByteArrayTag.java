package org.inventivetalent.nbt;

import com.google.gson.JsonArray;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.inventivetalent.nbt.stream.NBTOutputStream;

import java.io.DataOutputStream;
import java.io.IOException;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ByteArrayTag extends NBTTag<byte[]> {

	private final byte[] value;

	public ByteArrayTag(String name, byte[] value) {
		super(name);
		this.value = value;
	}

	@Override
	public byte[] getValue() {
		return value;
	}

	@Override
	public JsonArray asJson() {
		JsonArray jsonArray = new JsonArray();
		for (byte b : value) {
			jsonArray.add(b);
		}
		return jsonArray;
	}

	@Override
	public void write(NBTOutputStream nbtOut, DataOutputStream out) throws IOException {
		out.writeInt(value.length);
		out.write(value);
	}

	@Override
	public int getTypeId() {
		return TagID.TAG_BYTE_ARRAY;
	}

	@Override
	public String getTypeName() {
		return "TAG_Byte_Array";
	}
}
