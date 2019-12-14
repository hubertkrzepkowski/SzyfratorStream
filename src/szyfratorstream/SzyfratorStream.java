/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szyfratorstream;

/**
 *
 * @author HK
 */
public class SzyfratorStream {


        public String[] bin = {  "000000", "000001", "000010", "000011", "000100", "000101", "000110", "000111", "001000", "001001", "001010", "001011", "001100",
                                 "001101", "001110", "001111", "010000", "010001", "010010", "010011", "010100", "010101", "010110", "010111", "011000", "011001",
                                 "011010", "011011", "011100", "011101", "011110", "011111",
                                 "100000","100001","100010","100011","100100","100101","100110","100111","101000","101001","101010","101011","101100","101101",
                                 "101110","101111","110000","110001","110010","110011","110100","110101","110110","110111","111000","111001","111010","111011",
                                 "111100","111101","111110","111111",};

        public char[] sign =  {' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[','\\',']','^','_',
                               '`','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','{','|','}','~','#',};

        private char[] key;
        //private Boolean[] binaryTable;

      

        public boolean[] ConvertToBinary(char[] text,boolean [] binaryTable)
        {
            
            String binary = "";
            int k = 0, w = 0;
            for (int i = 0; i < text.length; i++)
            {
                for (int j = 0; j < 64; j++)
                {
                    if (text[i] == sign[j])binary += bin[j];
                }
            }
            k = 0;
            char[] bin = binary.toCharArray();
            for(char bit : bin)
            {

                if (bit == '0') binaryTable[w] = false;
                else binaryTable[w] = true;
                w++;
                k++;
            }
            return binaryTable;
        }
     
        public String encrypt(char[] text)
        {
            
           boolean[] binaryTable = new boolean[text.length*6];
            String tmp="";
            String binary = "", encrypt = "";
            boolean temp;
           binaryTable= ConvertToBinary(text,binaryTable);
            for(boolean c :binaryTable){
            System.out.print(c);
            }
            for (int i = 0; i < text.length*6; i++)
            {
                if(key[i] == '1'){
                  temp =  true ;
                 
                }else{
                  temp= false;
                }
                if ((binaryTable[i] ^ temp) == false)
                    binary = binary + "0";
                else binary= binary + "1";
            }
            for (int i = 0; i < binary.length(); i=i)
            {
                
                tmp = binary.substring(i, i+6);
                System.out.print(tmp);
                for (int j = 0; j < 64; j++)
                {
                    if (tmp.equals(bin[j])) encrypt += sign[j];
                }
                i=i+6;
            }
            System.out.print("qqq"+encrypt+"qqq");
            return encrypt;
        }

        public String decrypt(char[] cryptogram)
        {
           boolean[] binaryTable = new boolean[cryptogram.length * 6];
            String decrypt = "", binary = "", tmp = "";
            boolean temp;
           binaryTable= ConvertToBinary(cryptogram,binaryTable);
          
         
             for(boolean c :binaryTable){
            System.out.print(c);
            }
            for (int i = 0; i < cryptogram.length*6 ; i++)
            {
                  if(key[i] == '1'){
                  temp =  true ;
                 
                }else{
                  temp= false;
                }
                if ((binaryTable[i] ^ temp) == false)
                    binary = binary + "0";
                else binary = binary + "1";
            }
            System.out.print(binary);
            for (int i = 0; i < binary.length(); i=i)
            {
                tmp = binary.substring(i, i+6);
                System.out.print(tmp);
                for (int j = 0; j < 64; j++)
                {
                    if (tmp.equals(bin[j])) decrypt += sign[j];
                }
                i=i+6;
            }
            System.out.print("iii"+decrypt+"jjjjhh");
            return decrypt;
        }

        public void SetKey(char[]klucz)
        {
            this.key = klucz;
        }

//        public string decrypt_bin(String cryptogram)
//        {
//            binaryTable = new Boolean[cryptogram.Length * 6];
//            string decrypt = "", binary = "", tmp = "";
//            this.ConvertToBinary(cryptogram);
//            for (int i = 0; i < cryptogram.Length * 6; i++)
//            {
//                bool temp = (key[i] == '1') ? true : false;
//                if (binaryTable[i] ^ Convert.ToBoolean(temp) == false)
//                    binary = binary + "0";
//                else binary = binary + "1";
//            }
//            return binary;
//        }

    }
        



    

