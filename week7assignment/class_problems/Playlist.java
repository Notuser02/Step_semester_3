public class Playlist {
    private String[] songs;
    private int maxSize;
    private int count;

    public Playlist(int maxSize) {
        this.maxSize = maxSize;
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String title) {
        if (this.count < this.maxSize && title != null) {
            this.songs[this.count] = title;
            this.count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[this.count];
        System.arraycopy(this.songs, 0, copy, 0, this.count);
        return copy;
    }

    public int getSongCount() {
        return this.count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Playlist contents: " + p.getSongs()[0]);
        System.out.println("Copy contents: " + copy[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}