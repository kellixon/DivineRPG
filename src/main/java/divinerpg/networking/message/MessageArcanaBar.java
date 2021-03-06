package divinerpg.networking.message;

import divinerpg.DivineRPG;
import divinerpg.api.java.divinerpg.api.DivineAPI;
import divinerpg.api.java.divinerpg.api.arcana.IArcana;
import divinerpg.client.ArcanaRenderer;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageArcanaBar implements IMessage {

	private int delay;
	private float arcana;
	private float max;

	public MessageArcanaBar(){}

	public MessageArcanaBar(IArcana arcana) {
		if (arcana == null)
			return;

		delay = arcana.getRegenDelay();
		this.arcana = arcana.getArcana();
		max = arcana.getMaxArcana();
	}

	@Override
	public void fromBytes(ByteBuf byteBuf) {
		max = byteBuf.readFloat();
		arcana = byteBuf.readFloat();
		delay = byteBuf.readInt();
	}

	@Override
	public void toBytes(ByteBuf byteBuf) {
		byteBuf.writeFloat(max);
		byteBuf.writeFloat(arcana);
		byteBuf.writeInt(delay);
	}
	
	public static class Handler implements IMessageHandler<MessageArcanaBar, IMessage>{

		@Override
		public IMessage onMessage(MessageArcanaBar msg, MessageContext ctx) {

			if (ctx.side == Side.CLIENT) {
				IArcana capability = DivineAPI.getArcana(DivineRPG.proxy.getPlayer());
				capability.setMaxArcana(msg.max);
				capability.setRegenDelay(msg.delay);
				capability.set(msg.arcana);
			}

			ArcanaRenderer.percantage = (msg.arcana / msg.max) * 100;
			return null;
		}
		
	}
}