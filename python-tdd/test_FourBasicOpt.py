import unittest

from FourBasicOpt import FourBasicOpt


class FourBasicOptTest(unittest.TestCase):
    def setUp(self):
        self.calc = FourBasicOpt()

    def test_add_01(self):
        self.assertEqual(self.calc.add(100, 10), 110)

    def test_add_02(self):
        self.assertEqual(self.calc.add(100, -10), 90)

    def test_subtract_01(self):
        self.assertEqual(self.calc.subtract(100, 10), 90)

    def test_subtract_02(self):
        self.assertEqual(self.calc.subtract(100, -10), 110)

    def test_divide_01(self):
        self.assertEqual(self.calc.divide(100, 10), 10)

    def test_divide_02(self):
        self.assertEqual(self.calc.divide(100, 0), 0)

    def test_multiply_01(self):
        self.assertEqual(self.calc.multiply(100, 10), 1000)

    def test_multiply_02(self):
        self.assertEqual(self.calc.multiply(100, 1), 100)


if __name__ == "__main__":
    unittest.main()
