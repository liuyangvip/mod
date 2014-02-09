package buildcraft.transport.network;

import buildcraft.core.network.BuildCraftPacket;
import buildcraft.core.network.PacketIds;
import buildcraft.transport.TravelingItem;
import io.netty.buffer.ByteBuf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketPipeTransportItemStackRequest extends BuildCraftPacket {

	public int travelerID;
	public Player player;

	public PacketPipeTransportItemStackRequest(Player player) {
		this.player = player;
	}

	public PacketPipeTransportItemStackRequest(int travelerID) {
		this.travelerID = travelerID;
	}

	@Override
	public void writeData(ByteBuf data) {
		data.writeShort(travelerID);
	}

	@Override
	public void readData(ByteBuf data) {
		travelerID = data.readShort();
		TravelingItem.TravelingItemCache cache = TravelingItem.serverCache;
		TravelingItem item = cache.get(travelerID);
		if (item == null)
			return;
		PacketDispatcher.sendPacketToPlayer(new PacketPipeTransportItemStack(travelerID, item.getItemStack()).getPacket(), player);
	}

	@Override
	public int getID() {
		return PacketIds.PIPE_ITEMSTACK_REQUEST;
	}
}
