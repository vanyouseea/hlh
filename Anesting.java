package hqr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Anesting {
	
	public void validateID(String dummy ) {
		char[] ars1 = dummy.toCharArray();
		ArrayList<String> ids = new ArrayList<String>();
		
		if(ars1.length!=18) {
			System.out.println("length incorrect, should be 18 instead of"+ars1.length);
			System.exit(-1);
		}
		if(ars1[0]=='?'||ars1[1]=='?'||ars1[2]=='?'||ars1[3]=='?'||ars1[4]=='?'||ars1[5]=='?'||ars1[6]=='?'||ars1[7]=='?'||ars1[8]=='?'||ars1[9]=='?'||ars1[17]=='?') {
			System.out.println("Prefix 10 can't have ? and last char can't be ?");
			System.exit(-1);
		}
		
		String p1 =  String.valueOf(ars1[0]);
		String p2 =  String.valueOf(ars1[1]);
		String p3 =  String.valueOf(ars1[2]);
		String p4 =  String.valueOf(ars1[3]);
		String p5 =  String.valueOf(ars1[4]);
		String p6 =  String.valueOf(ars1[5]);
		String p7 =  String.valueOf(ars1[6]);
		String p8 =  String.valueOf(ars1[7]);
		String p9 =  String.valueOf(ars1[8]);
		String p10 = String.valueOf(ars1[9]);
		String p11 = String.valueOf(ars1[10]);
		String p12 = String.valueOf(ars1[11]);
		String p13 = String.valueOf(ars1[12]);
		String p14 = String.valueOf(ars1[13]);
		String p15 = String.valueOf(ars1[14]);
		String p16 = String.valueOf(ars1[15]);
		String p17 = String.valueOf(ars1[16]);
		String p18 = String.valueOf(ars1[17]);
		
		
		Calendar c = Calendar.getInstance();
		String year = p7 + p8 + p9 + p10;

		SimpleDateFormat MM = new SimpleDateFormat("MM");
		SimpleDateFormat dd = new SimpleDateFormat("dd");
		
		if("?".equals(p11)&&"?".equals(p12)) {
			System.out.println("Year:"+Integer.parseInt(year));
			c.set(Integer.parseInt(year), 0, 1);
			//One year
			for(int q=0;q<=c.get(Calendar.DAY_OF_YEAR);q++) {
				String p11p12 = MM.format(c.getTime());
				String p13p14 = dd.format(c.getTime());
				//check p15 p16 p17
				if("?".equals(p15)) {
					for(int y=0;y<10;y++) {
						if("?".equals(p16)) {
							for(int x=0;x<10;x++) {
								if("?".equals(p17)) {
									for(int i=0;i<10;i++) {
										String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+y+x+i+p18;
										ids.add(id);
									}
								}
								else {
									String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+y+x+p17+p18;
									ids.add(id);
								}
							}
						}
						else {
							if("?".equals(p17)) {
								for(int i=0;i<10;i++) {
									String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+y+p16+i+p18;
									ids.add(id);
								}
							}
							else {
								ids.add(p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+y+p16+p17+p18);
							}
						}
					}
				}
				else {
					if("?".equals(p16)) {
						for(int x=0;x<10;x++) {
							if("?".equals(p17)) {
								for(int i=0;i<10;i++) {
									String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+p15+x+i+p18;
									ids.add(id);
								}
							}
							else {
								String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+p15+x+p17+p18;
								ids.add(id);
							}
						}
					}
					else {
						if("?".equals(p17)) {
							for(int i=0;i<10;i++) {
								String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+p15+p16+i+p18;
								ids.add(id);
							}
						}
						//full 18 chars
						else {
							ids.add(p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11p12+p13p14+p15+p16+p17+p18);
						}
					}
				}
				c.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		else if(!"?".equals(p11)&&!"?".equals(p12)&&"?".equals(p13)&&"?".equals(p14)) {
			System.out.println("Year:"+Integer.parseInt(year)+" Month:"+(Integer.parseInt(p11+p12)-1));
			c.set(Integer.parseInt(year), Integer.parseInt(p11+p12)-1, 1);
			//one month
			for(int z=0;z<c.get(Calendar.DAY_OF_MONTH);z++) {
				String p13p14 = dd.format(c.getTime());
				//check p15 p16 p17
				if("?".equals(p15)) {
					for(int y=0;y<10;y++) {
						if("?".equals(p16)) {
							for(int x=0;x<10;x++) {
								if("?".equals(p17)) {
									for(int i=0;i<10;i++) {
										String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+y+x+i+p18;
										ids.add(id);
									}
								}
								else {
									String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+y+x+p17+p18;
									ids.add(id);
								}
							}
						}
						else {
							if("?".equals(p17)) {
								for(int i=0;i<10;i++) {
									String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+y+p16+i+p18;
									ids.add(id);
								}
							}
							else {
								ids.add(p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+y+p16+p17+p18);
							}
						}
					}
				}
				else {
					if("?".equals(p16)) {
						for(int x=0;x<10;x++) {
							if("?".equals(p17)) {
								for(int i=0;i<10;i++) {
									String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+p15+x+i+p18;
									ids.add(id);
								}
							}
							else {
								String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+p15+x+p17+p18;
								ids.add(id);
							}
						}
					}
					else {
						if("?".equals(p17)) {
							for(int i=0;i<10;i++) {
								String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+p15+p16+i+p18;
								ids.add(id);
							}
						}
						else {
							ids.add(p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13p14+p15+p16+p17+p18);
						}
					}
				}
				c.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		else if(!"?".equals(p11)&&!"?".equals(p12)&&!"?".equals(p13)&&!"?".equals(p14)) {
			//check p15 p16 p17
			if("?".equals(p15)) {
				for(int y=0;y<10;y++) {
					if("?".equals(p16)) {
						for(int x=0;x<10;x++) {
							if("?".equals(p17)) {
								for(int i=0;i<10;i++) {
									String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+y+x+i+p18;
									ids.add(id);
								}
							}
							else {
								String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+y+x+p17+p18;
								ids.add(id);
							}
						}
					}
					else {
						if("?".equals(p17)) {
							for(int i=0;i<10;i++) {
								String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+y+p16+i+p18;
								ids.add(id);
							}
						}
						else {
							ids.add(p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+y+p16+p17+p18);
						}
					}
				}
			}
			else {
				if("?".equals(p16)) {
					for(int x=0;x<10;x++) {
						if("?".equals(p17)) {
							for(int i=0;i<10;i++) {
								String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+x+i+p18;
								ids.add(id);
							}
						}
						else {
							String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+x+p17+p18;
							ids.add(id);
						}
					}
				}
				else {
					if("?".equals(p17)) {
						for(int i=0;i<10;i++) {
							String id = p1+p2+p3+p4+p5+p6+p7+p8+p9+p10+p11+p12+p13+p14+p15+p16+i+p18;
							ids.add(id);
						}
					}
					//full 18 chars
					else {
						ids.add(dummy);
					}
				}
			}
		}
		else {
			System.out.println("incorrect month or day");
			System.exit(-1);
		}
		
		verifyId(ids);
	}
	/*
	 * 1p * 7
	 * 2p * 9
	 * 3p * 10
	 * 4p * 5
	 * 5p * 8
	 * 6p * 4
	 * 7p * 2
	 * 8p * 1
	 * 9p * 6
	 * 10p * 3
	 * 11p * 7
	 * 12p * 9
	 * 13p * 10
	 * 14p * 5
	 * 15p * 8
	 * 16p * 4
	 * 17p * 2
	 * Sum%11 then
	 * 1 -> 0
	 * 0 -> 1
	 * 2 -> X
	 * 3 -> 9
	 * 4 -> 8
	 * 5 -> 7
	 * 6 -> 6
	 * 7 -> 5
	 * 8 -> 4
	 * 9 -> 3
	 * 10 -> 2
	 */
	public String verifyId(ArrayList<String> ary) {
		for (String str : ary) {
			char a[] = str.toCharArray();
			int p1  = a[0] - '0';
			int p2  = a[1] - '0';
			int p3  = a[2] - '0';
			int p4  = a[3] - '0';
			int p5  = a[4] - '0';
			int p6  = a[5] - '0';
			int p7  = a[6] - '0';
			int p8  = a[7] - '0';
			int p9  = a[8] - '0';
			int p10 = a[9] - '0';
			int p11 = a[10] - '0';
			int p12 = a[11] - '0';
			int p13 = a[12] - '0';
			int p14 = a[13] - '0';
			int p15 = a[14] - '0';
			int p16 = a[15] - '0';
			int p17 = a[16] - '0';
			String p18 = String.valueOf(a[17]) ;

			int yu = (p1 * 7+p2 * 9+p3 * 10+p4 * 5+p5 * 8+p6 * 4+p7 * 2+p8 * 1+p9 * 6+p10 * 3+p11 * 7+p12 * 9+p13 * 10+p14 * 5+p15 * 8+p16 * 4+p17 * 2)%11;
			String crc = "-1";

			if(yu==1) {
				crc = "0";
			}
			else if(yu==0) {
				crc = "1";
			}
			else if(yu==2) {
				crc = "X";
			}
			else if(yu==3) {
				crc = "9";
			}
			else if(yu==4) {
				crc = "8";
			}
			else if(yu==5) {
				crc = "7";
			}
			else if(yu==6) {
				crc = "6";
			}
			else if(yu==7) {
				crc = "5";
			}
			else if(yu==8) {
				crc = "4";
			}
			else if(yu==9) {
				crc = "3";
			}
			else if(yu==10) {
				crc = "2";
			}
			
			if(p18.equals(crc)) {
				System.out.println("OK:"+str);
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		Anesting an = new Anesting();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Pls input ID prefix (fixed length 18, the unknown field input ?, Ex:3206821996????175X):");
			String dummy = br.readLine();
			an.validateID(dummy);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
