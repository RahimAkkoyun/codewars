package playgroundbenchmark;

import java.util.*;
import java.util.stream.*;
import playgroundmain.playground1methods;

import org.openjdk.jmh.*;
import org.openjdk.jmh.annotations.*;


@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(1)
public class playground1benchmark
{
    // Declare Classes

    playground1methods utility;

    // Declare primitive data types
    private static boolean booleanValue;
    private static char charValue;
    private static byte byteValue;
    private static short shortValue;
    private static int intValue;
    private static long longValue;
    private static float floatValue;
    private static double doubleValue;
    private static String stringValue;

    // Declare arrays and lists for each primitive type
    private static boolean[] randomBooleanArray;
    private static char[] randomCharArray;
    private static byte[] randomByteArray;
    private static short[] randomShortArray;
    private static int[] randomIntArray;
    private static long[] randomLongArray;
    private static float[] randomFloatArray;
    private static double[] randomDoubleArray;
    private static String[] randomStringArray;

    private static List<Boolean> randomBooleanList;
    private static List<Character> randomCharList;
    private static List<Byte> randomByteList;
    private static List<Short> randomShortList;
    private static List<Integer> randomIntList;
    private static List<Long> randomLongList;
    private static List<Float> randomFloatList;
    private static List<Double> randomDoubleList;
    private static List<String> randomStringList;


    @Setup(Level.Trial)
    public void setUp() {
        utility = new playground1methods();
        Random random = new Random();

        // Initialize primitive data types
        booleanValue = random.nextBoolean();
        charValue = (char) (random.nextInt(26) + 'a');
        byteValue = (byte) random.nextInt(Byte.MAX_VALUE + 1);
        shortValue = (short) random.nextInt(Short.MAX_VALUE + 1);
        intValue = random.nextInt();
        longValue = random.nextLong();
        floatValue = random.nextFloat();
        doubleValue = random.nextDouble();
        stringValue = generateRandomString(random, random.nextInt(101));

        // Generate random arrays
        randomBooleanArray = generateRandomBooleanArray(5000);
        randomCharArray = generateRandomCharArray(5000);
        randomByteArray = generateRandomByteArray(5000);
        randomShortArray = generateRandomShortArray(5000);
        randomIntArray = generateRandomIntArray(5000);
        randomLongArray = generateRandomLongArray(5000);
        randomFloatArray = generateRandomFloatArray(5000);
        randomDoubleArray = generateRandomDoubleArray(5000);
        randomStringArray = generateRandomStringArray(5000);

        // Convert arrays to lists
        randomBooleanList = convertBooleanArrayToList(randomBooleanArray);
        randomCharList = convertCharArrayToList(randomCharArray);
        randomByteList = convertByteArrayToList(randomByteArray);
        randomShortList = convertShortArrayToList(randomShortArray);
        randomIntList = Arrays.stream(randomIntArray).boxed().collect(Collectors.toList());
        randomLongList = LongStream.of(randomLongArray).boxed().collect(Collectors.toList());
        randomFloatList = convertFloatArrayToList(randomFloatArray);
        randomDoubleList = DoubleStream.of(randomDoubleArray).boxed().collect(Collectors.toList());
        randomStringList = Arrays.asList(randomStringArray);
    }

    private static String[] generateRandomStringArray(int size) {
        Random random = new Random();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = generateRandomString(random, random.nextInt(101));
        }
        return array;
    }

    private static String generateRandomString(Random random, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) (random.nextInt(26) + 'a'));
        }
        return sb.toString();
    }

    private static boolean[] generateRandomBooleanArray(int size) {
        Random random = new Random();
        boolean[] array = new boolean[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextBoolean();
        }
        return array;
    }

    private static char[] generateRandomCharArray(int size) {
        Random random = new Random();
        char[] array = new char[size];
        for (int i = 0; i < size; i++) {
            array[i] = (char) (random.nextInt(26) + 'a');
        }
        return array;
    }

    private static byte[] generateRandomByteArray(int size) {
        Random random = new Random();
        byte[] array = new byte[size];
        for (int i = 0; i < size; i++) {
            array[i] = (byte) random.nextInt(Byte.MAX_VALUE + 1);
        }
        return array;
    }

    private static short[] generateRandomShortArray(int size) {
        Random random = new Random();
        short[] array = new short[size];
        for (int i = 0; i < size; i++) {
            array[i] = (short) random.nextInt(Short.MAX_VALUE + 1);
        }
        return array;
    }

    private static int[] generateRandomIntArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static long[] generateRandomLongArray(int size) {
        Random random = new Random();
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

    private static float[] generateRandomFloatArray(int size) {
        Random random = new Random();
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextFloat();
        }
        return array;
    }

    private static double[] generateRandomDoubleArray(int size) {
        Random random = new Random();
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextDouble();
        }
        return array;
    }

    private static List<Boolean> convertBooleanArrayToList(boolean[] array) {
        List<Boolean> list = new ArrayList<>(array.length);
        for (boolean b : array) {
            list.add(b);
        }
        return list;
    }

    private static List<Character> convertCharArrayToList(char[] array) {
        List<Character> list = new ArrayList<>(array.length);
        for (char c : array) {
            list.add(c);
        }
        return list;
    }

    private static List<Byte> convertByteArrayToList(byte[] array) {
        List<Byte> list = new ArrayList<>(array.length);
        for (byte b : array) {
            list.add(b);
        }
        return list;
    }

    private static List<Short> convertShortArrayToList(short[] array) {
        List<Short> list = new ArrayList<>(array.length);
        for (short s : array) {
            list.add(s);
        }
        return list;
    }

    private static List<Float> convertFloatArrayToList(float[] array) {
        List<Float> list = new ArrayList<>(array.length);
        for (float f : array) {
            list.add(f);
        }
        return list;
    }

    @Benchmark
    public void testhelloWorld()
    {
        utility.helloWorld();
    }
}