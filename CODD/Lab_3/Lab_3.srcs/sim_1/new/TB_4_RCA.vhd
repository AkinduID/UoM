----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/14/2023 11:17:31 PM
-- Design Name: 
-- Module Name: TB_4_RCA - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity TB_4_RCA is
--  Port ( );
end TB_4_RCA;

architecture Behavioral of TB_4_RCA is
COMPONENT RCA_4
PORT ( A0,A1,A2,A3,B0,B1,B2,B3,C_in:IN STD_LOGIC;
S0,S1,S2,S3,C_out:OUT STD_LOGIC);
END COMPONENT;

SIGNAL g0,g1,g2,g3,h0,h1,h2,h3,i0:std_logic;
SIGNAL o0,o1,o2,o3,o4:std_logic;
begin
UUT: RCA_4 PORT MAP(
A0 => g0,
A1 => g1,
A2 => g2,
A3 => g3,
B0=>h0,
B1=>h1,
B2=>h2,
B3=>h3,
C_in=>i0,
S0=>o0,
S1=>o1,
S2=>o2,
S3=>o3,
C_out=>o4);

process
begin
g0<='1'; h0<='0';i0<='0';  --index 1
g1<='0'; h1<='0';          --0001
g2<='0'; h2<='1';          --1100
g3<='0'; h3<='1';
WAIT FOR 100 ns;

g0<='0';h0<='1';   --index 2
g1<='0';h1<='1';   --0100
g2<='1';h2<='0';   --0011
g3<='0';h3<='0';
WAIT FOR 100 ns;
----------------------------------------------
g0<='1';h0<='1';   --0101
g1<='0';h1<='1';   --1011
g2<='1';h2<='0';
g3<='0';h3<='1';
WAIT FOR 100 ns;

g0<='1';h0<='1';   --0111
g1<='1';h1<='1';   --1111
g2<='1';h2<='1';
g3<='0';h3<='1';
WAIT FOR 100 ns;
---------------------------------------------1
g0<='0';h0<='1';  --0000
g1<='0';h1<='0';  --0001
g2<='0';h2<='0';
g3<='0';h3<='0';
WAIT FOR 100 ns;
----------------------------------------------2
g0<='1';h0<='1'; --0001
g1<='0';h1<='0'; --0001
g2<='0';h2<='0';
g3<='0';h3<='0';
WAIT FOR 100 ns;
-----------------------------------------------3
g0<='0';h0<='1'; --0010
g1<='1';h1<='0'; --0001
g2<='0';h2<='0';
g3<='0';h3<='0';
WAIT FOR 100 ns;
-----------------------------------------------4
g0<='0';h0<='1';  --0010
g1<='1';h1<='1';  --0011
g2<='0';h2<='0';
g3<='0';h3<='0';
WAIT;
end process;
end Behavioral;
