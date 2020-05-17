using System;

namespace flip
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(flips("000100110")); // shoud be 4
            Console.WriteLine(flips("01011")); // should be 3
            Console.WriteLine(flips("1111")); // should be 1
            Console.WriteLine(flips("0000")); // should be 0
            Console.WriteLine(flips("0101010101")); // should be 9
            Console.WriteLine(flips("1")); // should be 1
            Console.WriteLine(flips("0")); // should be 0
            Console.WriteLine(flips("00100000")); // should be 2
            Console.WriteLine(flips("10100010101101011010111101010001001101010")); // should be ?
        }


        public static int flips(string input) {

            if(input.IndexOf('1') == -1) return 0;

            int flipCount = 0 ;

            var len = input.Length;
            int[] start = new int[len];

            // find first 0
            for(int i = (len - 1); i >= 0; i--){

                int val = input[i] - '0';
                
                if(val == 0) {

                    if(i != 0) {
                        int leftVal = input[i - 1] - '0';
                        if(leftVal == 0) continue;
                    }

                    start = doFlip(i, start);
                    flipCount++;
                    break;
                }
            }

            if(flipCount == 0) return ++flipCount;

            // work from front
            for(int i = 0; i < len; i++){
                int val = input[i] - '0';

                if(val != start[i]) {
                    start = doFlip(i, start);
                    flipCount++;
                }
            }

            return flipCount;
        }

        public static int[] doFlip(int index, int[] array){

            for(; index < array.Length; index++) {
                array[index] = flipBit(array[index]);
            }

            return array;
        }

        public static int flipBit(int bit) {
            return bit == 0 ? 1 : 0;
        }
    }
}
