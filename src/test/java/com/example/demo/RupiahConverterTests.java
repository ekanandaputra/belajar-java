package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RupiahConverterTests {
    @Test
    void testConvertToRupiah() {
        assertEquals("Rp 1,000,000,00", RupiahConverter.convertToRupiah(1000000));
        assertEquals("Rp 500,000,00", RupiahConverter.convertToRupiah(500000));
        assertEquals("Rp 10,000,00", RupiahConverter.convertToRupiah(10000));
        assertEquals("Rp 100,00", RupiahConverter.convertToRupiah(100));
        assertEquals("Rp 1,00", RupiahConverter.convertToRupiah(1));
        assertEquals("Rp 0,00", RupiahConverter.convertToRupiah(0));
        
    }

    @Test
    void testConvertToRupiahUsingIDR() {
        assertEquals("IDR 1,000,000,00", RupiahConverter.convertToRupiah(1000000, true));
        assertEquals("IDR 500,000,00", RupiahConverter.convertToRupiah(500000, true));
        assertEquals("IDR 10,000,00", RupiahConverter.convertToRupiah(10000, true));
        assertEquals("IDR 100,00", RupiahConverter.convertToRupiah(100, true));
        assertEquals("IDR 1,00", RupiahConverter.convertToRupiah(1, true));
        assertEquals("IDR 0,00", RupiahConverter.convertToRupiah(0, true));
    }
}
