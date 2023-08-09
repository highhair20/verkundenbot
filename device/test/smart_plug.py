# smart_plug.py (The Python app)

class SmartPlug:
    def __init__(self):
        self.is_on = False

    def toggle_smart_plug(self):
        self.is_on = not self.is_on
        # Add code here to communicate with the smart plug and control its state

# test_smart_plug.py (The test file)

import unittest
from smart_plug import SmartPlug

class TestSmartPlug(unittest.TestCase):
    def test_toggle_smart_plug_on_off(self):
        # Create an instance of SmartPlug
        smart_plug = SmartPlug()

        # Test initial state
        self.assertFalse(smart_plug.is_on)

        # Toggle the smart plug state from off to on
        smart_plug.toggle_smart_plug()

        # Check if the state is on
        self.assertTrue(smart_plug.is_on)

        # Toggle the smart plug state from on to off
        smart_plug.toggle_smart_plug()

        # Check if the state is off again
        self.assertFalse(smart_plug.is_on)

if __name__ == '__main__':
    unittest.main()
