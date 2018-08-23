package test;

import junit.framework.TestCase;
import socialNetwork.Wrapper;

import java.io.File;

public class WrapperTest extends TestCase {

  Wrapper w;
  Wrapper w2;
  Wrapper w3;
  Wrapper w4;
  Wrapper w5;

  String simpleGraphFile = "/Users/ejrgilbert/Documents/School/2015-2016/Fall/CSC316/projects/project03/CSC316Project3/Project_3/src/test/files/tests_beginner/simple-graph.txt";
  String boundaryGraphFile = "/Users/ejrgilbert/Documents/School/2015-2016/Fall/CSC316/projects/project03/CSC316Project3/Project_3/src/test/files/tests_beginner/boundary-graph.txt";
  String k5 = "/Users/ejrgilbert/Documents/School/2015-2016/Fall/CSC316/projects/project03/CSC316Project3/Project_3/src/test/files/tests_uberIntense/k5.txt";
  String big = "/Users/ejrgilbert/Documents/School/2015-2016/Fall/CSC316/projects/project03/CSC316Project3/Project_3/src/test/files/tests_uberIntense/n_00125_07500.txt";
  String p5 = "/Users/ejrgilbert/Documents/School/2015-2016/Fall/CSC316/projects/project03/CSC316Project3/Project_3/src/test/files/tests_uberIntense/p5.txt";

  public void setUp() throws Exception {
    super.setUp();

    w = new Wrapper(new File(simpleGraphFile));
    w2 = new Wrapper(new File(boundaryGraphFile));
    w3 = new Wrapper(new File(k5));
    w4 = new Wrapper(new File(big));
    w5 = new Wrapper(new File(p5));
  }

  public void testIsFriend() throws Exception {
    setUp();
    assertTrue(w.isFriend("Natasha", "Diego"));
    assertFalse(w.isFriend("Omar", "Natasha"));
  }

  public void testMutualFriends() throws Exception {
    setUp();

    assertEquals("Shantal\n", w.mutualFriends("Prabhu", "Billy"));
    assertEquals("Diego\nSally\n", w.mutualFriends("Omar", "Natasha"));
    assertEquals("", w.mutualFriends("Sally", "Prabhu"));

    // BIG TEST
    assertEquals("sdcqgvqllv\nvxwfxcbjba\nzmouadvctf\neaoqwtwiei\nmchbchhlem\nukvsjegbsv\n" +
      "fiwjqrgcmu\n" +
      "wuatxvcehd\n" +
      "ykqxyxqard\n" +
      "frugmoaunx\n" +
      "kzoypbiwfi\n" +
      "aoliyaopon\n" +
      "vzckfdsxsu\n" +
      "frkxotocki\n" +
      "dlxffmhgrv\n" +
      "ugqssvcjqh\n" +
      "ujcorkavij\n" +
      "oahynbtrca\n" +
      "vleedgenjo\n" +
      "tcnhbztudj\n" +
      "thqqsdhllp\n" +
      "stdffmlple\n" +
      "qsgekjwinn\n" +
      "absswcqvdy\n" +
      "toqjtdwlqm\n" +
      "glkxmxrucy\n" +
      "mrkyaeyned\n" +
      "swdtnvywtg\n" +
      "pyuokpksoa\n" +
      "itxeuvepbf\n" +
      "zyyayrrrgf\n" +
      "xaeclyzsww\n" +
      "hiznehvdwo\n" +
      "vpwomemoog\n" +
      "mqvzmhzuyj\n" +
      "ewajuabngi\n" +
      "eibqlchptp\n" +
      "naqvfswauu\n" +
      "jlgyfejayh\n" +
      "tikcwofxgh\n" +
      "bkhpqbhwdh\n" +
      "rqsogocusc\n" +
      "molisvlqrh\n" +
      "tcyxzetxyz\n" +
      "rocrisczhd\n" +
      "lncsltzwdm\n" +
      "jupfqfphja\n" +
      "kkfwwqezox\n" +
      "azdutwxskq\n" +
      "idbkdoacif\n" +
      "jsopkurmso\n" +
      "gxkhvpdpmn\n" +
      "hqdmnfnuzs\n" +
      "doicgixnmd\n" +
      "zgngymohsy\n" +
      "lfyzunnftt\n" +
      "bvxdtjvogx\n" +
      "aihemyfsjg\n" +
      "nollthmthr\n" +
      "mplcyedcat\n" +
      "jeoqdeuzzv\n" +
      "sspauqqlrc\n" +
      "hllxnjkzwt\n" +
      "linvofpzwx\n" +
      "yxgvybmpir\n" +
      "qvwssobrmd\n" +
      "qdidmowsqm\n" +
      "ncwevvxkih\n" +
      "kadikzujbc\n" +
      "jzlpfykrlv\n" +
      "nhfdnmruar\n" +
      "wetmfhlplx\n" +
      "fbdrngemjp\n" +
      "xdhtfyidra\n" +
      "nchkaxgkmf\n" +
      "buzvrywdqu\n" +
      "wcufjkxqtw\n" +
      "pvrmpludzg\n" +
      "ufcjumzjpz\n" +
      "sriqxauajx\n" +
      "qeyzwzzgwb\n" +
      "bqxlwsrhzd\n" +
      "khnciqbcrr\n" +
      "ygwrodqzsn\n" +
      "xvojjzaema\n" +
      "oyzgwpdkcx\n" +
      "dmcpjalwvz\n" +
      "txnxhibhvc\n" +
      "wcfzrghpar\n" +
      "nfgfitqleq\n" +
      "uzqlxsqgmb\n" +
      "qynwfhmmwk\n" +
      "zfhkvmzvhe\n" +
      "thpqzjvgfe\n" +
      "sjndqtmvja\n" +
      "qybhuxwfah\n" +
      "ntdlaoiuod\n" +
      "ccojfebboz\n" +
      "eglztofcoy\n" +
      "asjfxuclsw\n" +
      "pwpcaminpb\n" +
      "kyqfgmhtss\n" +
      "hxcdzrjoeu\n" +
      "rkpozblgim\n" +
      "apeplhskpt\n" +
      "zlmhgjpzbt\n" +
      "suxlojbbee\n" +
      "ywvlrmdake\n" +
      "swhqopuuha\n" +
      "asoyikoojz\n" +
      "ajkibgbeva\n" +
      "wjnbzpmbbh\n" +
      "olgpgxnmzz\n" +
      "vfisuknavq\n" +
      "cwkxxregkz\n" +
      "hmjiyhvtae\n", w4.mutualFriends("tgicoazbdz", "khcvuesxvh"));

  }

  public void testRelation() throws Exception {
    setUp();

    assertEquals("Natasha\nSally\nOmar\n", w.relation("Natasha", "Omar"));
    assertEquals("", w.relation("Diego", "Billy"));
    assertEquals("Diego\nNatasha\n", w.relation("Diego", "Natasha"));
  }

  public void testNotConnected() throws Exception {
    setUp();

    assertEquals(12, w.notConnected());
    assertEquals(0, w4.notConnected());
  }

  public void testComputePopular() throws Exception {
    setUp();

    // Do the b5_popular.in
    assertEquals("Sally\nShantal\nDiego\n", w.computePopular());

    assertEquals("E\nJ\n", w2.computePopular());

    assertEquals("alpha\nbeta\ngamma\ndelta\nepsilon\n", w3.computePopular());

    assertEquals("tcnhbztudj\n", w4.computePopular());

    w5.isFriend("epsilon", "epsilon");
    w5.mutualFriends("epsilon", "epsilon");
    w5.relation("epsilon", "epsilon");
    assertEquals(0, w5.notConnected());
    assertEquals("delta\n", w5.computePopular());
  }
}