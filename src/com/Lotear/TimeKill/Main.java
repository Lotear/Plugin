package com.Lotear.TimeKill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener
{
	private List<String> player = new ArrayList<String>();
	private List<String> target = new ArrayList<String>();
	private int time = 0;
	
	private List<Integer> timelist = new ArrayList<>();
	private int time1 = 300;
	private int time2 = 300;
	private int time3 = 300;
	private int time4 = 300;
	private int time5 = 300;
	private int time6 = 300;

	public ItemStack sword1 = new ItemStack(Material.DIAMOND_SWORD);
	public ItemStack sword2 = new ItemStack(Material.IRON_SWORD);
	public ItemStack sword3 = new ItemStack(Material.GOLD_SWORD);
	public ItemStack sword4 = new ItemStack(Material.STICK);
	public ItemStack bow1 = new ItemStack(Material.BOW);
	public ItemStack bow2 = new ItemStack(Material.BOW);
	public ItemStack bow3 = new ItemStack(Material.BOW);
	public ItemStack boost = new ItemStack(Material.GHAST_TEAR);
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		
		ItemMeta im1 = sword1.getItemMeta();
		im1.setDisplayName("신비로운 배틀엑스");
		sword1.setItemMeta(im1);
		
		ItemMeta im2 = bow1.getItemMeta();
		im2.setDisplayName("좋은 총");
		im2.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
		im2.addEnchant(Enchantment.DURABILITY, 1, false);
		bow1.setItemMeta(im2);
		
		ItemMeta im3 = sword2.getItemMeta();
		im3.setDisplayName("푸른 칼");
		sword2.setItemMeta(im3);
		
		ItemMeta im4 = sword3.getItemMeta();
		im4.setDisplayName("칼");
		sword3.setItemMeta(im4);
		
		ItemMeta im5 = sword4.getItemMeta();
		im5.setDisplayName("젓가락");
		sword4.setItemMeta(im5);
		
		ItemMeta im6 = bow2.getItemMeta();
		im6.setDisplayName("화살 나가는 총");
		bow2.setItemMeta(im6);
		
		ItemMeta im7 = boost.getItemMeta();
		im7.setDisplayName("시간의 결정");
		boost.setItemMeta(im7);
	}
	
	public void onDisable()
	{
		
	}
	
	public boolean onCommand(CommandSender cs, Command c, String label, String[] args)
	{
		
		Player lotear = (Player) cs;
		
		if(label.equalsIgnoreCase("game"))
		{
			if(args[0].equalsIgnoreCase("stop"))
			{
				Bukkit.getScheduler().cancelTask(time);
				for(Player all : Bukkit.getOnlinePlayers())
				{
					all.sendTitle(ChatColor.GREEN + "게임 종료!", args[1] +" 승리!");
				}
			}
			else if(args[0].equalsIgnoreCase("remove"))
			{
				lotear.sendMessage(player.toString());
				//lotear.sendMessage(target.toString());
			}
			else if(args[0].equalsIgnoreCase("start"))
			{
				lotear.chat("/t t");
				
				player.clear();
				target.clear();
				timelist.clear();
				
				timelist.add(time1);
				timelist.add(time2);
				timelist.add(time3);
				timelist.add(time4);
				timelist.add(time5);
				timelist.add(time6);
				
				player.add("Sleepground");
				player.add("ehdgh141");
				player.add("SUHYEN");
				player.add("HSRD");
				player.add("Heptagram");
				player.add("DUCKGAE");
//				
//				player.add("Lotear");
//				player.add("revoicetial");
				
				
				Collections.shuffle(player);
				
				lotear.sendMessage(player.toString());
				
				
				
				for(int i = 1;i<player.size();i++)
				{
					target.add(player.get(i));
				}
				
				target.add(player.get(0));
				
				//lotear.sendMessage(target.toString());
				
				for(String str : player)
				{
					Player p = Bukkit.getServer().getPlayer(str);
					p.setGameMode(GameMode.SURVIVAL);
					p.getInventory().addItem(sword1);
					p.getInventory().addItem(bow1);
					p.getInventory().addItem(new ItemStack(Material.ARROW, 64));
					p.getInventory().setItem(8, new ItemStack(Material.COMPASS));
					p.getInventory().setItem(7, boost);
				}
				
				time = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
					
					int num = 20;
					
					@Override
					public void run()
					{
						switch (num)
						{
							case 1:
								
								for(int i = 0;i<player.size();i++)
								{
									
									if(timelist.get(i) >= 240)
									{
										Player p = Bukkit.getServer().getPlayer(player.get(i));
										try
										{
											p.getInventory().remove(Material.IRON_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.GOLD_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.STICK);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											for(ItemStack itm : p.getInventory().getContents())
											{
												if((itm.getType().equals(Material.BOW)) && !(itm.getItemMeta().getDisplayName().equals("좋은 총")))
												{
													p.getInventory().remove(Material.BOW);
												}
											}
										
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										if(!p.getInventory().contains(Material.DIAMOND_SWORD))
										{
											p.getInventory().addItem(sword1);
										}
										if(!p.getInventory().contains(Material.BOW))
										{
											p.getInventory().addItem(bow1);
										}
										p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
									}
									else if(timelist.get(i) >= 120)
									{
										Player p = Bukkit.getServer().getPlayer(player.get(i));
										try
										{
											p.getInventory().remove(Material.DIAMOND_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.STICK);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.GOLD_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											for(ItemStack itm : p.getInventory().getContents())
											{
												if((itm.getType().equals(Material.BOW)) && !(itm.getItemMeta().getDisplayName().equals("화살 나가는 총")))
												{
													p.getInventory().remove(Material.BOW);
												}
											}
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										if(!p.getInventory().contains(Material.IRON_SWORD))
										{
											p.getInventory().addItem(sword2);
										}
										if(!p.getInventory().contains(Material.BOW))
										{
											p.getInventory().addItem(bow2);
										}
										p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
									}
									else if(timelist.get(i) >= 30)
									{
										Player p = Bukkit.getServer().getPlayer(player.get(i));
										try
										{
											p.getInventory().remove(Material.IRON_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.STICK);
										}
										
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.DIAMOND_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											for(ItemStack itm : p.getInventory().getContents())
											{
												if((itm.getType().equals(Material.BOW)) && !(itm.getItemMeta().getDisplayName().equals("화살 나가는 총")))
												{
													p.getInventory().remove(Material.BOW);
												}
											}
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										if(!p.getInventory().contains(Material.GOLD_SWORD))
										{
											p.getInventory().addItem(sword3);
										}
										if(!p.getInventory().contains(Material.BOW))
										{
											p.getInventory().addItem(bow2);
										}
										p.getInventory().setChestplate(new ItemStack(Material.AIR));
									}
									else if(timelist.get(i) > 0)
									{
										Player p = Bukkit.getServer().getPlayer(player.get(i));
										try
										{
											p.getInventory().remove(Material.GOLD_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.DIAMOND_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										try
										{
											p.getInventory().remove(Material.IRON_SWORD);
										}
										catch (NullPointerException e) {
											// TODO: handle exception
										}
										if(!p.getInventory().contains(Material.STICK))
										{
											p.getInventory().addItem(sword4);
										}
									}
									else if(timelist.get(i) <= 0)
									{
										Player p = Bukkit.getServer().getPlayer(player.get(i));
										int tmpt = timelist.get(i);
										for(Player all : Bukkit.getOnlinePlayers())
										{
											all.sendTitle(p.getName() +ChatColor.RED + " 탈락!", " ");
											all.sendMessage(ChatColor.AQUA + "[" +ChatColor.GREEN + "KillorDeath" +ChatColor.AQUA +  "] " + ChatColor.WHITE + "누군가의 시간이 끝났습니다....");
											
										}
										
										p.setGameMode(GameMode.SPECTATOR);
										
										
										timelist.remove(tmpt);
										//target.remove(p.getName());
										player.remove(p.getName());
										
										for(int t = 0; t<timelist.size(); t++)
										{
											int tmp = timelist.get(t) + 20;
											timelist.set(t, tmp);
										}
									}
								}
								
								for(int j = 0 ; j<player.size();j++)
								{
									if(j == player.size()-1)
									{
										Player tmp = Bukkit.getServer().getPlayer(player.get(j));
										Player tmptarget = Bukkit.getServer().getPlayer(player.get(0));
										tmp.setCompassTarget(tmptarget.getLocation());
									
									}
									else
									{
										Player tmp = Bukkit.getServer().getPlayer(player.get(j));
										Player tmptarget = Bukkit.getServer().getPlayer(player.get(j+1));
										tmp.setCompassTarget(tmptarget.getLocation());
									}
								}
								
								for(int t = 0;t<timelist.size();t++)
								{
									int tmp = timelist.get(t) - 1;
									timelist.set(t, tmp);
								}
								
								for(int j = 0 ; j<player.size();j++)
								{
									Player tmp = Bukkit.getServer().getPlayer(player.get(j));
									int tmptime = timelist.get(j);
								
									
									tmp.chat("/title " + tmp.getName() + " actionbar {\"text\":\""+timeSet(tmp.getName(), tmptime)+"\"}");
									//ActionBar bar = new ActionBar(timeSet(tmp.getName(), tmptime));
									
									
									//bar.sendToPlayer(tmp);
								}
								num = 20;
								break;
								
							default:
								for(int j = 0 ; j<player.size();j++)
								{
									
									Player tmp = Bukkit.getServer().getPlayer(player.get(j));
									if(j == player.size()-1)
									{
										Player tmptarget = Bukkit.getServer().getPlayer(player.get(0));
										tmp.setCompassTarget(tmptarget.getLocation());
									
									}
									else
									{
										Player tmptarget = Bukkit.getServer().getPlayer(player.get(j+1));
										tmp.setCompassTarget(tmptarget.getLocation());
									}
								}
								num--;
								break;
						}
						
					}
					
				}, 0L, 1L);
			}
		}
		
		return false;
	}
	
	@EventHandler
	public void FallDamage(EntityDamageEvent ev)
	{
		if(ev.getEntity() instanceof Player)
		{
			if(ev.getCause() == DamageCause.FALL)
			{
				ev.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void boost(PlayerInteractEvent ev)
	{
		try
		{
			if(ev.getPlayer().getItemInHand().getType().equals(Material.GHAST_TEAR) && (ev.getAction().equals(Action.RIGHT_CLICK_AIR) || (ev.getAction().equals(Action.RIGHT_CLICK_BLOCK))))
			{
				ev.getPlayer().sendTitle("§a시간 §b가속!!!", "");
				Player tmp = ev.getPlayer();
				int inx = player.indexOf(tmp.getName());
				int now = timelist.get(inx);
				timelist.set(inx, (now - 30));
				tmp.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2), false);
				tmp.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 400, 2), false);
			}
		}
		catch (NullPointerException e)
		{
			// TODO: handle exception
		}
	}
	
	@EventHandler
	public void PlayerDeathEvent(PlayerDeathEvent ev)
	{
		Player victim = ev.getEntity();
		Player killer = victim.getKiller();
		
		try
		{
			if(((player.indexOf(victim.getName())==0) && (player.indexOf(killer.getName())==(player.size()-1))) || ((player.indexOf(victim.getName()) - player.indexOf(killer.getName())) == 1))
			{
				for(Player all : Bukkit.getOnlinePlayers())
				{
					all.sendTitle(victim.getName() +ChatColor.RED + " 탈락!", " ");
					
				}
				victim.setGameMode(GameMode.SPECTATOR);
				
				int tmp = player.indexOf(victim.getName());
				
				int tmpvic = timelist.get(player.indexOf(victim.getName()));
				int tmpkill = timelist.get(player.indexOf(killer.getName())) + tmpvic;
				int killindex = player.indexOf(killer.getName());
				timelist.set(killindex, tmpkill);
				
				player.remove(tmp);
				timelist.remove(tmp);
			}
			
//			if(target.indexOf(victim.getName()) == player.indexOf(killer.getName()))
//			{
//				for(Player all : Bukkit.getOnlinePlayers())
//				{
//					all.sendTitle(victim.getName() +ChatColor.RED + " 탈락!", " ");
//					
//				}
//				
//				victim.setGameMode(GameMode.SPECTATOR);
//				int tmpvic = timelist.get(player.indexOf(victim.getName()));
//				int tmpkill = timelist.get(player.indexOf(killer.getName())) + tmpvic;
//				int vicindex = timelist.indexOf(tmpvic);
//				int killindex = player.indexOf(killer.getName());
//				timelist.set(killindex, tmpkill);
//				Integer vicnum = timelist.get(vicindex);
//				
//				
//				if(killindex == 0)
//				{
//					player.set(0, player.get(player.size()-1));
//					player.remove(player.size()-1);
//					target.remove(victim.getName());
//					timelist.set(0, timelist.get(timelist.size()-1));
//					timelist.remove(timelist.get(timelist.size()-1));
//				}
//				else
//				{
//					target.remove(victim.getName());
//					player.remove(victim.getName());
//					timelist.remove(vicnum);
//				}
//				
//			}
			else
			{
				killer.sendMessage(ChatColor.AQUA + "[" +ChatColor.GREEN + "KillorDeath" +ChatColor.AQUA +  "] " + ChatColor.WHITE + "타겟이 아닌 사람을 잡았습니다! 패널티를 받습니다....");
				
				int tmpkill = timelist.get(player.indexOf(killer.getName())) - (player.size() * 20);
				
				if(tmpkill<=0)
				{
					for(Player all : Bukkit.getOnlinePlayers())
					{
						all.sendTitle(killer.getName() +ChatColor.RED + " 탈락!", " ");
						all.sendMessage(ChatColor.AQUA + "[" +ChatColor.GREEN + "KillorDeath" +ChatColor.AQUA +  "] " + ChatColor.WHITE + "누군가의 시간이 끝났습니다....");
						
						
						
					}
					player.remove(killer.getName());
					timelist.remove(player.indexOf(killer.getName()));
				}
				
				int killindex = player.indexOf(killer.getName());
				timelist.set(killindex, tmpkill);
				

				for(int t = 0; t<timelist.size(); t++)
				{
					int tmp = timelist.get(t) + 20;
					timelist.set(t, tmp);
				}
			}
		}
		catch (NullPointerException e)
		{
			// TODO: handle exception
		}
	}
	
	public String timeSet(String name, int time)
	{
		
		int minute = time/60;
		int second = time%60;
		
		String timetmp = "§a남은 시간 : §b" + minute + "§f분 §b" + second + "§f초";
		
		return timetmp;
	}
}
